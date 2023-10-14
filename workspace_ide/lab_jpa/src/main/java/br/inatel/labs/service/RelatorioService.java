package br.inatel.labs.service;

import br.inatel.labs.dto.TotalCompradoPorFornecedorDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {
    @PersistenceContext
    EntityManager entityManager;

    public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
        String jpql = """
                SELECT new br.inatel.labs.dto.TotalCompradoPorFornecedorDTO
                    ( f.razaoSocial
                    , SUM( i.quantidade * i.valorCompraProduto )
                    )
                FROM NotaCompraItem i
                JOIN i.notaCompra  n
                JOIN n.fornecedor  f
                GROUP BY f.razaoSocial
                """;

        return entityManager.createQuery(jpql, TotalCompradoPorFornecedorDTO.class).getResultList();
    }
}
