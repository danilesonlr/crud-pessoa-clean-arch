package br.com.pessoa.repository;

import br.com.pessoa.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaEntityRepository extends JpaRepository<PessoaEntity, Long> {
}
