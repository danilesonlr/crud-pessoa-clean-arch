package br.com.pessoa.gateway;

import br.com.pessoa.entities.Endereco;

public interface EnderecoGateway {

    Endereco buscarEnderecoPorCep(String cep);
}
