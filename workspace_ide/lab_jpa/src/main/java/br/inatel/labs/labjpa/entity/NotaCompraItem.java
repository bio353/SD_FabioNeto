package br.inatel.labs.labjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
public class NotaCompraItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private NotaCompra notaCompra;

    @ManyToOne
    private Produto produto;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    @Positive
    private BigDecimal valorCompraProduto;

    public BigDecimal getCalculoTotalItem() {
        return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotaCompra getNotaCompra() {
        return notaCompra;
    }

    public void setNotaCompra(NotaCompra notaCompra) {
        this.notaCompra = notaCompra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorCompraProduto() {
        return valorCompraProduto;
    }

    public void setValorCompraProduto(BigDecimal valorCompraProduto) {
        this.valorCompraProduto = valorCompraProduto;
    }
}
