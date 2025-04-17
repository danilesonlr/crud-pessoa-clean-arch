package br.com.pessoa.usecases.impl;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.usecases.AlterarPessoaUseCase;

public class AlterarPessoaUseCaseImpl implements AlterarPessoaUseCase {

    private final PessoaDomainGateway pessoaRepository;

    public AlterarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void alterarPessoa(Pessoa input, Long id) {
        Pessoa atual = pessoaRepository.buscarPorId(id);

        atual.setNome(input.getNome());
        atual.setCpf(input.getCpf());
        atual.setDateNascimento(input.getDateNascimento());
        atual.setTelefone(input.getTelefone());
        pessoaRepository.salvar(atual);
    }
}
