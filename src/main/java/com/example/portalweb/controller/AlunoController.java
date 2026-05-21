package com.example.portalweb.controller;

import com.example.portalweb.model.Aluno;
import com.example.portalweb.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{rmAluno}")
    public ResponseEntity<Aluno> buscar(@PathVariable String rmAluno) {
        return service.buscarPorRm(rmAluno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno criar(@Valid @RequestBody Aluno aluno) {
        return service.criar(aluno);
    }

    @PutMapping("/{rmAluno}")
    public ResponseEntity<Aluno> atualizar(@PathVariable String rmAluno, @Valid @RequestBody Aluno aluno) {
        return service.atualizar(rmAluno, aluno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{rmAluno}")
    public ResponseEntity<Void> deletar(@PathVariable String rmAluno) {
        if (service.deletar(rmAluno)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}