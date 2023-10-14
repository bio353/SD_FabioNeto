package br.inatel.labs.service;

import br.inatel.labs.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import java.util.List;

@Service
@Transactional
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public void remover(Produto produto) {
        repository.delete(produto);
    }
}
