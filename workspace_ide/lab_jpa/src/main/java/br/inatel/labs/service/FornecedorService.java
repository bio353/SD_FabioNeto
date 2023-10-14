package br.inatel.labs.service;

import br.inatel.labs.entity.Fornecedor;
import br.inatel.labs.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Fornecedor buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public void remover(Fornecedor fornecedor) {
        repository.delete(fornecedor);
    }
}
