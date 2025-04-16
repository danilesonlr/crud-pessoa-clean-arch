package br.com.pessoa.usecases.impl;

import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.usecases.DeletarPessoaUseCase;

public class DeletarPessoaUseCaseImpl implements DeletarPessoaUseCase {
    private final PessoaDomainGateway pessoaRepository;

    public DeletarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository) {
       this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepository.deletarPorId(id);
    }
}
