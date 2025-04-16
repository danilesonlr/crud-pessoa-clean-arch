package br.com.pessoa.usecases;

import br.com.pessoa.entities.Pessoa;

public interface BuscarPessoaUseCase {
    Pessoa buscarPorId(Long id);
}
