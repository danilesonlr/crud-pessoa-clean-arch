package br.com.pessoa.repository;

import br.com.pessoa.entities.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaDomainRepository {
    void salvar(Pessoa pessoa);
    Pessoa buscarPorId(Long id);
    List<Pessoa> buscarTodos();
    void deletarPorId(Long id);
}
