package br.inatel.labs.service;

import br.inatel.labs.entity.NotaCompra;
import br.inatel.labs.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NotaCompraService {
    @PersistenceContext
    private EntityManager entityManager;

    // NotaCompra

    public NotaCompra salvar(NotaCompra notaCompra) {
        entityManager.merge(notaCompra);
        return notaCompra;
    }

    public NotaCompra buscarPeloId(Long id) {
        return entityManager.find(NotaCompra.class, id);
    }

    public NotaCompra buscarPeloIdComListaItem(Long id) {
        NotaCompra notaCompra = entityManager.find(NotaCompra.class, id);
        notaCompra.getListaNotaCompraItem().size();
        return notaCompra;
    }

    public List<NotaCompra> listar() {
        String jpql = "SELECT nc FROM NotaCompra nc";
        return entityManager.createQuery(jpql, NotaCompra.class).getResultList();
    }

    // NotaCompraItem

    public NotaCompraItem salvar(NotaCompraItem notaCompraItem) {
        entityManager.merge(notaCompraItem);
        return notaCompraItem;
    }

    public NotaCompraItem buscarItemPeloId(Long id) {
        return entityManager.find(NotaCompraItem.class, id);
    }

    public List<NotaCompraItem> listarItem() {
        String jpql = "SELECT nci FROM NotaCompraItem nci";
        return entityManager.createQuery(jpql, NotaCompraItem.class).getResultList();
    }
}
