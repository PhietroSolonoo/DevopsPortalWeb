package com.example.portalweb.controller;

import com.example.portalweb.model.Produto;
import com.example.portalweb.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscar(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@Valid @RequestBody Produto produto) {
        return service.criar(produto);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> atualizar(@PathVariable String codigo, @Valid @RequestBody Produto produto) {
        return service.atualizar(codigo, produto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable String codigo) {
        if (service.deletar(codigo)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}