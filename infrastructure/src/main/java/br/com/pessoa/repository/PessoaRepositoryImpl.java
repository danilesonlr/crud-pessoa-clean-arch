package br.com.pessoa.repository;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryImpl implements PessoaDomainRepository {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaRepositoryImpl(@Lazy PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }
    @Override
    public void salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoaMapper.toDTO(pessoa));
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaMapper
                .toEntity(pessoaRepository.findById(id)
                .orElseThrow());
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll()
                .stream()
                .map(e -> pessoaMapper.toEntity(e))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepository.deleteById(id);
    }
}
