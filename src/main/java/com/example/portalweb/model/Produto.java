package com.example.portalweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "t_produto")
public class Produto {

    @Id
    @Column(name = "codigo")
    private String codigo;  // ex: "P001"

    @NotBlank
    private String nome;

    @NotNull
    @PositiveOrZero
    private Double preco;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeEstoque;

    public Produto() {}

    public Produto(String codigo, String nome, Double preco, Integer quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // getters e setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
}