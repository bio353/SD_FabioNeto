package br.inatel.labs.entity;

import br.inatel.labs.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoTest {
    @Autowired
    EnderecoService service;

    @Test
    public void testarUUIDGeradoPeloJPAListener() {
        Endereco endereco = new Endereco();
        endereco.setRua("Av. João de Camargo");
        endereco.setNumero("510");
        endereco.setCidade("Santa Rita do Sapucaí");
        endereco.setUf("MG");

        endereco = service.salvar(endereco);
        System.out.println(endereco);
    }
}
