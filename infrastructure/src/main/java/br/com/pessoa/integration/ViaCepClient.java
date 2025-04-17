package br.com.pessoa.integration;

import br.com.pessoa.entities.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws") // url="${notification-api.url}"
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    Endereco buscar(@PathVariable("cep") String cep);
}
