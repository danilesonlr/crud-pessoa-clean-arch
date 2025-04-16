package br.com.pessoa.service;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.infrastructure.mapper.PessoaMapper;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.repository.PessoaEntityRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PessoaServiceImpl implements PessoaDomainGateway {

    private final PessoaEntityRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaServiceImpl(@Lazy PessoaEntityRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public void salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoaMapper.toEntity(pessoa));
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaMapper
                .toEntitie(pessoaRepository.findById(id)
                .orElseThrow());
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll()
                .stream()
                .map(e -> pessoaMapper.toEntitie(e))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepository.deleteById(id);
    }
}
