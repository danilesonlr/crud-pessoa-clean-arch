package br.com.pessoa.usecases.impl;

import br.com.pessoa.dto.PessoaDto;
import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.repository.PessoaDomainRepository;

import java.util.UUID;

public class CadastrarPessoaUseCase  {
    private final PessoaDomainRepository pessoaRepository;

    public CadastrarPessoaUseCase(PessoaDomainRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void execute(PessoaDto input, Void key) {
        Pessoa pessoa = new Pessoa( input.getId(),
                input.getNome(),
                input.getCpf(),
                input.getDataNascimento(),
                input.getTelefone());
        pessoaRepository.salvar(pessoa);
    }
}
