package com.example.processdocument.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AiServiceClient {
    private final WebClient webClient;

    public AiServiceClient(WebClient.Builder webClientBuilder, @Value("${ai.service.url}") String aiServiceUrl) {
        this.webClient = webClientBuilder.baseUrl(aiServiceUrl).build();
    }

    public Mono<Void> processDocument(Long documentId, String text) {
        return webClient.post()
                .uri("/process-document/")
                .bodyValue(Map.of("document_id", documentId.toString(), "text", text))
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<String> queryDocument(Long documentId, String query) {
        return webClient.post()
                .uri("/query-document/")
                .bodyValue(Map.of("document_id", documentId.toString(), "query", query))
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (String) response.get("answer"));
    }
}
