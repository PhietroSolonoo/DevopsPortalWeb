package com.example.portalweb.service;

import com.example.portalweb.model.Produto;
import com.example.portalweb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorCodigo(String codigo) {
        return repository.findById(codigo);
    }

    public Produto criar(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> atualizar(String codigo, Produto produtoAtualizado) {
        return repository.findById(codigo).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
            return repository.save(produto);
        });
    }

    public boolean deletar(String codigo) {
        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);
            return true;
        }
        return false;
    }
}