package br.inatel.labs.service;

import br.inatel.labs.entity.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EnderecoService {
    @PersistenceContext
    private EntityManager entityManager;

    public Endereco salvar(Endereco endereco) {
        entityManager.merge(endereco);
        return endereco;
    }

    public Endereco buscarPeloId(String id) {
        return entityManager.find(Endereco.class, id);
    }

    public void remover(Endereco endereco) {
        Endereco enderecoParaRemover = entityManager.merge(endereco);
        entityManager.remove(enderecoParaRemover);
    }
}
