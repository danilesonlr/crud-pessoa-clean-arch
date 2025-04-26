package br.com.pessoa.repository;

import br.com.pessoa.entity.acesso.AcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcessorEntityRepository extends JpaRepository<AcessoEntity, Long> {
    Optional<AcessoEntity> findByLogin(String login);
}
