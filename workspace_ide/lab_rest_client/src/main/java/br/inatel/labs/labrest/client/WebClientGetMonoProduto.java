package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProduto {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        try {
            Mono<ProdutoDTO> monoProduto = WebClient.create(BASE_URL).get().uri("/produto/{id}", 1).retrieve().bodyToMono(ProdutoDTO.class);

            ProdutoDTO produto = monoProduto.block();

            System.out.println("Produto encontrado");
            System.out.println(produto);
        } catch (WebClientResponseException e) {
            System.out.println("Status Code: " + e.getStatusCode());
            System.out.println("Mensagem: " + e.getMessage());
        }
    }
}
