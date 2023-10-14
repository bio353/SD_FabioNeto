package br.inatel.labs.service;

import br.inatel.labs.dto.TotalCompradoPorFornecedorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RelatorioServiceTest {
    @Autowired
    private RelatorioService service;

    @Test
    public void test() {
        List<TotalCompradoPorFornecedorDTO> listaDTO = service.pesquisarTotalCompradoPorFornecedor();

        assertFalse(listaDTO.isEmpty());

        System.out.println("FornecedorRazaoSocial : TotalComprado");
        listaDTO.forEach(relatorio -> {
            System.out.println(relatorio.fornecedorRazaoSocial());
            System.out.println(" : ");
            System.out.println(relatorio.totalComprado());
        });
    }

}
