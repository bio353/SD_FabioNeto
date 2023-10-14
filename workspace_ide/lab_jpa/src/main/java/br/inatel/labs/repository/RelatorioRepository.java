package br.inatel.labs.repository;

import br.inatel.labs.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.entity.NotaCompraItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioRepository extends JpaRepository<NotaCompraItem, Long> {
    @Query("""
            SELECT new br.inatel.labs.dto.TotalCompradoPorFornecedorDTO
                ( f.razaoSocial
                , SUM( i.quantidade * i.valorCompraProduto )
                )
            FROM NotaCompraItem i
            JOIN i.notaCompra  n
            JOIN n.fornecedor  f
            GROUP BY f.razaoSocial
            """)
    public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor();
}
