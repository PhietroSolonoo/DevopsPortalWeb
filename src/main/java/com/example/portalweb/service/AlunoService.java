package com.example.portalweb.service;

import com.example.portalweb.model.Aluno;
import com.example.portalweb.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Optional<Aluno> buscarPorRm(String rm) {
        return repository.findById(rm);
    }

    public Aluno criar(Aluno aluno) {
        return repository.save(aluno);
    }

    public Optional<Aluno> atualizar(String rm, Aluno alunoAtualizado) {
        return repository.findById(rm).map(aluno -> {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setTurma(alunoAtualizado.getTurma());
            return repository.save(aluno);
        });
    }

    public boolean deletar(String rm) {
        if (repository.existsById(rm)) {
            repository.deleteById(rm);
            return true;
        }
        return false;
    }
}