package br.inatel.labs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class Endereco {
    @Id
    private String codigo;

    @NotNull
    private String rua;

    @NotNull
    private String numero;

    private String complemento;

    private String bairro;

    @NotNull
    private String cidade;

    @NotNull
    @Size(min = 2, max = 2)
    private String uf;

    @PrePersist
    private void preencherCodigo() {
        codigo = UUID.randomUUID().toString();
    }
}
