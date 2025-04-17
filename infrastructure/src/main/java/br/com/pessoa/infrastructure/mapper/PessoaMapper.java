package br.com.pessoa.infrastructure.mapper;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.entity.PessoaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PessoaMapper {

    Pessoa toEntitie(PessoaEntity entity);

    @Mapping(target = "id", ignore = true)
    PessoaEntity toEntity(Pessoa pessoa);
}
