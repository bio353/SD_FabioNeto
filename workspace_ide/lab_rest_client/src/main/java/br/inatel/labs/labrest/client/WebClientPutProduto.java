package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientPutProduto {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        ProdutoDTO produtoExistente = new ProdutoDTO();
        produtoExistente.setId(1L);
        produtoExistente.setDescricao("Furadeira à Bateria");

        ResponseEntity<Void> responseEntity = WebClient.create(BASE_URL).put().uri("/produto/{id}", 1).bodyValue(produtoExistente).retrieve().toBodilessEntity().block();

        HttpStatusCode statusCode = responseEntity.getStatusCode();

        System.out.println("Produto Atualizado");
        System.out.println("Status Code: " + statusCode);

    }
}
