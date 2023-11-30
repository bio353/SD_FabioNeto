package br.inatel.labs.labrest.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientDeleteProdutoPeloId {
    private static final String BASE_URL = "http://localhost:8080/";

    public static void main(String[] args) {
        try {

            ResponseEntity<Void> responseEntity = WebClient.create(BASE_URL).delete().uri("produto/3").retrieve().toEntity(Void.class).block();

            HttpStatusCode statusCode = responseEntity.getStatusCode();

            System.out.println("Produto Removido");
            System.out.println("Status Code: " + statusCode);
        } catch (WebClientResponseException e) {
            System.out.println("Status Code: " + e.getStatusCode());
        }
    }
}
