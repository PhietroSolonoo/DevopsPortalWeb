package com.example.portalweb.service;

import com.example.portalweb.dto.EntregaRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {

    @Value("${app.webhook.url:https://webhook.site/example}")
    private String webhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public void enviarParaWebhook(EntregaRequest entrega) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(webhookUrl, entrega, String.class);
            System.out.println("Webhook resposta: " + response.getStatusCode());
        } catch (Exception e) {
            System.err.println("Erro ao enviar webhook: " + e.getMessage());
        }
    }
}