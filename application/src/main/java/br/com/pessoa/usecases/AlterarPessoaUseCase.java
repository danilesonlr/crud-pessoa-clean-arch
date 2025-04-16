package br.com.pessoa.usecases;

import br.com.pessoa.entities.Pessoa;

public interface AlterarPessoaUseCase {
    void alterarPessoa(Pessoa input, Long key);
}
