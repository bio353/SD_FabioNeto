package br.inatel.labs.labjpa;

import br.inatel.labs.entity.Fornecedor;
import br.inatel.labs.entity.NotaCompra;
import br.inatel.labs.entity.NotaCompraItem;
import br.inatel.labs.entity.Produto;
import br.inatel.labs.service.FornecedorService;
import br.inatel.labs.service.NotaCompraService;
import br.inatel.labs.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
class DataLoader {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private NotaCompraService notaCompraService;

    @Test
    void load() {
        // Produto

        Produto p1 = new Produto("Furadeira");
        Produto p2 = new Produto("Lixadeira");
        Produto p3 = new Produto("Plaina");
        Produto p4 = new Produto("Tupia");
        Produto p5 = new Produto("Serra Circular");

        p1 = produtoService.salvar(p1);
        p2 = produtoService.salvar(p2);
        p3 = produtoService.salvar(p3);
        p4 = produtoService.salvar(p4);
        p5 = produtoService.salvar(p5);

        List<Produto> listaProduto = produtoService.listar();
        listaProduto.forEach(System.out::println);

        // Fornecedor

        Fornecedor f1 = new Fornecedor("Gasômetro Madeiras");
        Fornecedor f2 = new Fornecedor("Loja do Mecânico");

        f1 = fornecedorService.salvar(f1);
        f2 = fornecedorService.salvar(f2);

        List<Fornecedor> listaFornecedor = fornecedorService.listar();
        listaFornecedor.forEach(System.out::println);

        // NotaCompra

        NotaCompra nc1 = new NotaCompra(LocalDate.of(2021, 1, 15), f1);
        nc1 = notaCompraService.salvar(nc1);

        NotaCompra nc2 = new NotaCompra(LocalDate.of(2022, 2, 20), f2);
        nc2 = notaCompraService.salvar(nc2);

        // NotaCompraItem

        NotaCompraItem i1 = new NotaCompraItem(nc1, p1, new BigDecimal("300.00"), 2);
        NotaCompraItem i2 = new NotaCompraItem(nc1, p2, new BigDecimal("1000.00"), 2);
        NotaCompraItem i3 = new NotaCompraItem(nc1, p3, new BigDecimal("500.00"), 2);

        i1 = notaCompraService.salvarItem(i1);
        i2 = notaCompraService.salvarItem(i2);
        i3 = notaCompraService.salvarItem(i3);

        List<NotaCompraItem> itens = notaCompraService.listarItem();
        itens.forEach(System.out::println);
    }
}
