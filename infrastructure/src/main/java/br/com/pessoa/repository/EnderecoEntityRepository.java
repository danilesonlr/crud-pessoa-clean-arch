package br.com.pessoa.repository;

import br.com.pessoa.entity.EnderecoEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface EnderecoEntityRepository extends JpaAttributeConverter<EnderecoEntity, Long> {
}
