package br.inatel.labs.service;

import br.inatel.labs.entity.NotaCompra;
import br.inatel.labs.entity.NotaCompraItem;
import br.inatel.labs.repository.NotaCompraItemRepository;
import br.inatel.labs.repository.NotaCompraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NotaCompraService {
    @Autowired
    private NotaCompraRepository notaCompraRepository;

    @Autowired
    private NotaCompraItemRepository notaCompraItemRepository;

    // NotaCompra

    public NotaCompra salvar(NotaCompra notaCompra) {
        return notaCompraRepository.save(notaCompra);
    }

    public NotaCompra buscarPeloId(Long id) {
        return notaCompraRepository.findById(id).orElseThrow();
    }

    public NotaCompra buscarPeloIdComListaItem(Long id) {
        NotaCompra notaCompra = notaCompraRepository.findById(id).orElseThrow();
        notaCompra.getListaNotaCompraItem().size();
        return notaCompra;
    }

    public List<NotaCompra> listar() {
        return notaCompraRepository.findAll();
    }

    // NotaCompraItem

    public NotaCompraItem salvar(NotaCompraItem notaCompraItem) {
        return notaCompraItemRepository.save(notaCompraItem);
    }

    public NotaCompraItem buscarItemPeloId(Long id) {
        return notaCompraItemRepository.findById(id).orElseThrow();
    }

    public List<NotaCompraItem> listarItem() {
        return notaCompraItemRepository.findAll();
    }
}
