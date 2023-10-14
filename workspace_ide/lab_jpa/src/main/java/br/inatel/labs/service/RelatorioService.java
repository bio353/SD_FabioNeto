package br.inatel.labs.service;

import br.inatel.labs.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {
    @Autowired
    private RelatorioRepository repository;

    public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
        return repository.pesquisarTotalCompradoPorFornecedor();
    }
}
