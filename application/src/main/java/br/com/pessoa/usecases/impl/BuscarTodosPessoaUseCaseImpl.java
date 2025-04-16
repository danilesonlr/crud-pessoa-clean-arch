package br.com.pessoa.usecases.impl;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.usecases.BuscarTodosPessoaUseCase;

import java.util.List;

public class BuscarTodosPessoaUseCaseImpl implements BuscarTodosPessoaUseCase {

    private final PessoaDomainGateway pessoaRepository;


    public BuscarTodosPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.buscarTodos();
    }
}
