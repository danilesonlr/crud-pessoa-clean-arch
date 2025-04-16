package br.com.pessoa.gateway;

import br.com.pessoa.entities.Pessoa;

import java.util.List;

public interface PessoaDomainGateway {
    void salvar(Pessoa pessoa);
    Pessoa buscarPorId(Long id);
    List<Pessoa> buscarTodos();
    void deletarPorId(Long id);
}
