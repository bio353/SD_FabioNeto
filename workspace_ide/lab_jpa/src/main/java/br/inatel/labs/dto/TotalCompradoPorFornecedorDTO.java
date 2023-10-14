package br.inatel.labs.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record TotalCompradoPorFornecedorDTO(@NotNull @Size(min = 2, max = 200) String fornecedorRazaoSocial,
                                            BigDecimal totalComprado) {

}
