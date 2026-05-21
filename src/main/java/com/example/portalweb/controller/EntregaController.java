package com.example.portalweb.controller;

import com.example.portalweb.dto.EntregaRequest;
import com.example.portalweb.service.WebhookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private WebhookService webhookService;

    @PostMapping
    public ResponseEntity<String> receberEntrega(@Valid @RequestBody EntregaRequest entrega) {
        webhookService.enviarParaWebhook(entrega);
        return ResponseEntity.ok("Entrega registrada e encaminhada ao webhook do professor.");
    }
}