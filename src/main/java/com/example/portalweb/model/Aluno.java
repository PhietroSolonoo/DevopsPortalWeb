package com.example.portalweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "t_aluno")
public class Aluno {

    @Id
    @Column(name = "rm_aluno")
    private String rmAluno;

    @NotBlank
    private String nome;

    @NotBlank
    private String turma;

    public Aluno() {}

    public Aluno(String rmAluno, String nome, String turma) {
        this.rmAluno = rmAluno;
        this.nome = nome;
        this.turma = turma;
    }

    // getters e setters
    public String getRmAluno() { return rmAluno; }
    public void setRmAluno(String rmAluno) { this.rmAluno = rmAluno; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }
}