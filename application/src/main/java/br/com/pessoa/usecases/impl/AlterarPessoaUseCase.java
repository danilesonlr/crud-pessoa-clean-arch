package br.com.pessoa.usecases.impl;

import br.com.pessoa.dto.PessoaDto;
import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.repository.PessoaDomainRepository;

public class AlterarPessoaUseCase {

    private final PessoaDomainRepository pessoaRepository;

    public AlterarPessoaUseCase(PessoaDomainRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void execute(PessoaDto input, Long key) {
        Pessoa atual = pessoaRepository.buscarPorId(key);

        atual.setNome(input.getNome());
        atual.setCpf(input.getCpf());
        atual.setDataNascimento(input.getDataNascimento());
        atual.setTelefone(input.getTelefone());
        pessoaRepository.salvar(atual);
    }
}
