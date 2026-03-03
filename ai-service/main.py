import os
import traceback
from fastapi import FastAPI, HTTPException, BackgroundTasks
from pydantic import BaseModel
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_community.document_loaders import PyPDFLoader
from langchain_chroma import Chroma
from langchain_huggingface import HuggingFaceEmbeddings
from langchain.chains import RetrievalQA
from langchain_google_genai import ChatGoogleGenerativeAI # --- IMPORT GEMINI ---

# --- CONFIGURATION ---
# Define a persistent directory for ChromaDB
CHROMA_PERSIST_DIR = "chroma_db_storage"
# Define the embedding model
EMBEDDING_MODEL_NAME = "all-MiniLM-L6-v2"

# --- INITIALIZATION ---
app = FastAPI(title="Document Q&A AI Service")

# Initialize embeddings
print("Loading embedding model...")
embeddings = HuggingFaceEmbeddings(model_name=EMBEDDING_MODEL_NAME)
print("Embedding model loaded.")

# Initialize a persistent ChromaDB client
vectorstore = Chroma(
    embedding_function=embeddings, 
    persist_directory=CHROMA_PERSIST_DIR
)
print(f"ChromaDB initialized. Data will be persisted in '{CHROMA_PERSIST_DIR}'.")

# --- Initialize LLM with Google Gemini ---
def initialize_llm():
    """Initialize Google Gemini LLM with proper error handling"""
    api_key = os.getenv("GOOGLE_API_KEY")
    
    if not api_key:
        raise ValueError("GOOGLE_API_KEY environment variable is required")
    
    try:
        model_name = "gemini-2.5-flash"
        print(f"Attempting to initialize model: {model_name}")
        
        llm = ChatGoogleGenerativeAI(
            model=model_name,
            google_api_key=api_key,
            temperature=0.1,
            convert_system_message_to_human=True # Helps with some chain types
        )
        
        # Test the model with a simple call
        print(f"Testing model {model_name}...")
        test_response = llm.invoke("What is AI?")
        print(f"✅ Successfully initialized model: {model_name}")
        print(f"Test response: {test_response.content}...")
        return llm
            
    except Exception as e:
        print(f"❌ Failed to initialize {model_name}: {str(e)}")
        traceback.print_exc()
        raise Exception("Failed to initialize the LLM model")

# Initialize LLM with error handling
llm = None
try:
    llm = initialize_llm()
except Exception as e:
    print(f"🚨 LLM initialization failed: {e}")
    print("The service will start but queries will fail until LLM is fixed.")

# --- Pydantic Models for API validation ---
class DocumentProcessRequest(BaseModel):
    document_id: str
    text: str

class QueryRequest(BaseModel):
    document_id: str
    query: str

class QueryResponse(BaseModel):
    answer: str

class HealthResponse(BaseModel):
    status: str
    llm_initialized: bool
    chroma_persist_dir: str
    message: str

# --- Helper Function to process and store text ---
def process_and_store_text(document_id: str, text: str):
    """
    Splits text, creates embeddings, and stores them in ChromaDB.
    This runs in the background.
    """
    try:
        print(f"🔄 Starting background processing for document_id: {document_id}")
        
        # 1. Split text into chunks
        text_splitter = RecursiveCharacterTextSplitter(
            chunk_size=200, 
            chunk_overlap=10
        )
        docs = text_splitter.create_documents([text])
        print(f"Split text into {len(docs)} chunks")
        
        # 2. Add metadata to each chunk
        for i, doc in enumerate(docs):
            doc.metadata = {"document_id": document_id, "chunk_num": i}
            
        # 3. Remove existing documents with same ID if any
        try:
            existing_docs = vectorstore.get(where={"document_id": document_id})
            if existing_docs and existing_docs.get('ids'):
                print(f"🗑️ Removing {len(existing_docs['ids'])} existing chunks for document_id: {document_id}")
                vectorstore.delete(ids=existing_docs['ids'])
        except Exception as e:
            print(f"Note: Could not check for existing documents: {e}")
        
        # 4. Add new documents to the vector store
        ids = [f"{document_id}_{i}" for i, _ in enumerate(docs)]
        vectorstore.add_documents(documents=docs, ids=ids)
        
        # 5. Persist the changes to disk
        print(f"✅ Successfully processed and stored document_id: {document_id} ({len(docs)} chunks)")

    except Exception as e:
        print(f"❌ Error processing document {document_id}: {e}")
        traceback.print_exc()

# --- API ENDPOINTS ---
@app.get("/health", response_model=HealthResponse)
async def health_check():
    """Health check endpoint"""
    message = "Service is healthy" if llm else "Service running but LLM not initialized"
    return HealthResponse(
        status="healthy" if llm else "degraded",
        llm_initialized=llm is not None,
        chroma_persist_dir=CHROMA_PERSIST_DIR,
        message=message
    )

@app.post("/process-document/")
async def process_document_endpoint(request: DocumentProcessRequest, background_tasks: BackgroundTasks):
    """
    Receives text and a document ID, then triggers a background task to process it.
    """
    if not request.text.strip():
        raise HTTPException(status_code=400, detail="Document text cannot be empty")
    
    if len(request.text) < 10:
        raise HTTPException(status_code=400, detail="Document text too short (minimum 10 characters)")
    
    background_tasks.add_task(process_and_store_text, request.document_id, request.text)
    return {
        "message": f"Document processing started in background for document_id: {request.document_id}",
        "text_length": len(request.text)
    }

@app.post("/query-document/", response_model=QueryResponse)
async def query_document_endpoint(request: QueryRequest):
    """
    Queries the vector store for a given document_id and returns an answer.
    """
    try:
        if llm is None:
            raise HTTPException(
                status_code=503, 
                detail="LLM service is not available. Check GOOGLE_API_KEY and network connection."
            )
        
        print(f"🔍 Query received for document_id: {request.document_id}")
        print(f"Query: {request.query}")
        
        # Check if the document exists in the vector store
        try:
            existing_docs = vectorstore.get(where={"document_id": request.document_id})
            if not existing_docs or not existing_docs.get('ids'):
                raise HTTPException(
                    status_code=404, 
                    detail=f"No documents found for document_id: {request.document_id}. Please process the document first."
                )
            print(f"✅ Found {len(existing_docs['ids'])} chunks for document_id: {request.document_id}")
        except HTTPException:
            raise
        except Exception as e:
            print(f"Error checking document existence: {e}")
            raise HTTPException(status_code=500, detail="Error accessing document store")
        
        # Create a retriever
        retriever = vectorstore.as_retriever(
            search_type="similarity",
            search_kwargs={
                "k": 10, 
                "filter": {"document_id": request.document_id}
            }
        )

        # Test retrieval first
        try:
            retrieved_docs = retriever.get_relevant_documents(request.query)
            if not retrieved_docs:
                return QueryResponse(answer="No relevant information found in the document for your query.")
            print(f"📄 Retrieved {len(retrieved_docs)} relevant chunks")
        except Exception as e:
            print(f"Error during document retrieval: {e}")
            raise HTTPException(status_code=500, detail="Failed to retrieve relevant documents")

        # Create a RetrievalQA chain
        try:
            qa_chain = RetrievalQA.from_chain_type(
                llm=llm,
                chain_type="stuff",
                retriever=retriever,
                return_source_documents=False
            )

            # Execute the query
            print(f"🤖 Executing query with LLM...")
            result = qa_chain.invoke({"query": request.query})
            
            answer = result.get('result', 'No answer generated')
            print(f"✅ Answer generated: {answer}...")
            return QueryResponse(answer=answer)
            
        except Exception as e:
            print(f"❌ Error during LLM processing: {e}")
            traceback.print_exc()
            raise HTTPException(status_code=500, detail=f"LLM processing failed: {str(e)}")

    except HTTPException:
        raise
    except Exception as e:
        print(f"❌ Unexpected error during query: {e}")
        traceback.print_exc()
        raise HTTPException(status_code=500, detail=f"Query processing failed: {str(e)}")

@app.get("/documents/{document_id}")
async def get_document_info(document_id: str):
    """Get information about a processed document"""
    try:
        existing_docs = vectorstore.get(where={"document_id": document_id})
        
        if not existing_docs or not existing_docs.get('ids'):
            raise HTTPException(status_code=404, detail=f"Document {document_id} not found")
        
        return {
            "document_id": document_id,
            "chunk_count": len(existing_docs['ids']),
            "chunk_ids": existing_docs['ids'][:5]  # Show first 5 chunk IDs
        }
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Error retrieving document info: {str(e)}")

@app.get("/documents/")
async def list_documents():
    """List all processed documents"""
    try:
        # Get all documents from vectorstore
        all_docs = vectorstore.get()
        
        # Extract unique document IDs
        doc_ids = set()
        if all_docs and all_docs.get('metadatas'):
            for metadata in all_docs['metadatas']:
                if metadata and 'document_id' in metadata:
                    doc_ids.add(metadata['document_id'])
        
        return {
            "total_documents": len(doc_ids),
            "document_ids": list(doc_ids),
            "total_chunks": len(all_docs.get('ids', [])) if all_docs else 0
        }
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Error listing documents: {str(e)}")

# --- Startup event ---
@app.on_event("startup")
async def startup_event():
    """Startup checks"""
    print("\n" + "="*50)
    print("🚀 Starting Document Q&A AI Service")
    print("="*50)
    
    # Check API token for Google
    token = os.getenv("GOOGLE_API_KEY")
    if not token:
        print("⚠️  WARNING: GOOGLE_API_KEY not set!")
        print("   Get a key from: https://aistudio.google.com/app/apikey")
        print("   Set it with: export GOOGLE_API_KEY='your_token_here'")
    else:
        print(f"✅ Google API key found (length: {len(token)})")
    
    # Check LLM status
    if llm is None:
        print("❌ LLM not initialized - queries will fail")
        print("   Check your API key and internet connection")
    else:
        print("✅ LLM initialized successfully")
    
    print("="*50)
    print("📚 Available endpoints:")
    print("   GET  /health           - Service health check")
    print("   GET  /documents        - List all documents")
    print("   GET  /documents/{id}   - Get document info")
    print("   POST /process-document - Process new document")
    print("   POST /query-document   - Query existing document")
    print("="*50 + "\n")

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)