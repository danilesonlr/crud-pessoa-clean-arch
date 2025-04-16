package br.com.pessoa.usecases.impl;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.usecases.CadastrarPessoaUseCase;

public class CadastrarPessoaUseCaseImpl implements CadastrarPessoaUseCase {
    private final PessoaDomainGateway pessoaRepository;

    public CadastrarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void salvar(Pessoa input) {
        Pessoa pessoa = new Pessoa( input.getId(),
                input.getNome(),
                input.getCpf(),
                input.getDataNascimento(),
                input.getTelefone());
        pessoaRepository.salvar(pessoa);
    }
}
