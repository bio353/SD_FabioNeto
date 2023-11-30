package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class WebClientGetFluxoProduto {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        List<ProdutoDTO> listaProduto = new ArrayList<ProdutoDTO>();

        Flux<ProdutoDTO> fluxProduto = WebClient.create(BASE_URL).get().uri("/produto").retrieve().bodyToFlux(ProdutoDTO.class);

        fluxProduto.subscribe(p -> listaProduto.add(p));

        fluxProduto.blockLast();

        System.out.printf("Lista de Produtos: %s\n", listaProduto);
    }
}
