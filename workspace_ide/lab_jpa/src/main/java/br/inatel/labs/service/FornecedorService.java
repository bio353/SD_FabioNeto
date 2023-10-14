package br.inatel.labs.service;

import br.inatel.labs.entity.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FornecedorService {
    @PersistenceContext
    private EntityManager entityManager;

    public Fornecedor salvar(Fornecedor fornecedor) {
        entityManager.merge(fornecedor);
        return fornecedor;
    }

    public Fornecedor buscarPeloId(Long id) {
        return entityManager.find(Fornecedor.class, id);
    }

    public List<Fornecedor> listar() {
        String jpql = "SELECT f FROM Fornecedor f";
        return entityManager.createQuery(jpql, Fornecedor.class).getResultList();
    }

    public void remover(Fornecedor fornecedor) {
        Fornecedor fornecedorParaRemover = entityManager.merge(fornecedor);
        entityManager.remove(fornecedorParaRemover);
    }
}
