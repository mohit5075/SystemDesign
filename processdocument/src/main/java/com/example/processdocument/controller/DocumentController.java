package com.example.processdocument.controller;

import com.example.processdocument.dto.DocumentResponse;
import com.example.processdocument.dto.QueryRequest;
import com.example.processdocument.entity.Document;
import com.example.processdocument.service.AiServiceClient;
import com.example.processdocument.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;
    private final AiServiceClient aiServiceClient;

    public DocumentController(DocumentService documentService, AiServiceClient aiServiceClient) {
        this.documentService = documentService;
        this.aiServiceClient = aiServiceClient;
    }

    @PostMapping("/upload")
    public ResponseEntity<DocumentResponse> uploadDocument(@RequestParam("file") MultipartFile file, Principal principal) throws IOException {
        Document doc = documentService.saveDocument(file, principal.getName());
        return ResponseEntity.ok(new DocumentResponse(doc.getId(), doc.getFilename(), "Processing started."));
    }

    @PostMapping("/{documentId}/query")
    public Mono<ResponseEntity<String>> queryDocument(@PathVariable Long documentId, @RequestBody QueryRequest queryRequest) {
        return aiServiceClient.queryDocument(documentId, queryRequest.getQuery())
                .map(ResponseEntity::ok);
    }
}
