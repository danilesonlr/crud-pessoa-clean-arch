package br.com.pessoa.infrastructure.mapper;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.entity.PessoaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toEntitie(PessoaEntity entity);

    PessoaEntity toEntity(Pessoa pessoa);
}
