package com.example.processdocument.service;

import com.example.processdocument.entity.Document;
import com.example.processdocument.entity.User;
import com.example.processdocument.repository.DocumentRepository;
import com.example.processdocument.repository.UserRepository;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.pdfbox.Loader;

import java.io.IOException;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    private final AiServiceClient aiServiceClient;

    public DocumentService(DocumentRepository documentRepository, UserRepository userRepository, AiServiceClient aiServiceClient) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
        this.aiServiceClient = aiServiceClient;
    }

    public Document saveDocument(MultipartFile file, String username) throws IOException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Document document = new Document();
        document.setFilename(file.getOriginalFilename());
        document.setUser(user);
        Document savedDocument = documentRepository.save(document);

        processDocument(savedDocument, file);
        return savedDocument;
    }

    @Async
    public void processDocument(Document document, MultipartFile file) {
        try {
            String text = extractTextFromPdf(file);
            aiServiceClient.processDocument(document.getId(), text).subscribe();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String extractTextFromPdf(MultipartFile file) throws IOException {
        try (PDDocument document = Loader.loadPDF(file.getBytes())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}
