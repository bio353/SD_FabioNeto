package br.inatel.labs.service;

import br.inatel.labs.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProdutoService {
    @PersistenceContext
    private EntityManager entityManager;

    public Produto salvar(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    public Produto buscarPeloId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> listar() {
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public void remover(Produto produto) {
        Produto produtoParaRemover = entityManager.merge(produto);
        entityManager.remove(produtoParaRemover);
    }
}
