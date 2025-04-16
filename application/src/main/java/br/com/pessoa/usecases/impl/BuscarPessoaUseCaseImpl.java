package br.com.pessoa.usecases.impl;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.usecases.BuscarPessoaUseCase;

public class BuscarPessoaUseCaseImpl implements BuscarPessoaUseCase {

    private final PessoaDomainGateway pessoaRepository;

    public BuscarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.buscarPorId(id);
    }
}
