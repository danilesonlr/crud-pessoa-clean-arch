package br.com.pessoa.repository;

import br.com.pessoa.entity.EnderecoEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoEntityRepository extends JpaRepository<EnderecoEntity, Long> {
}
