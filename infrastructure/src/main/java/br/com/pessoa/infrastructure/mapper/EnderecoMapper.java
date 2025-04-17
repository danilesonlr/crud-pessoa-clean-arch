package br.com.pessoa.infrastructure.mapper;

import br.com.pessoa.entities.Endereco;
import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.entity.EnderecoEntity;
import br.com.pessoa.entity.PessoaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    Endereco toEntitie(EnderecoEntity entity);

    @Mapping(target = "id", ignore = true)
    EnderecoEntity toEntity(Endereco pessoa);
}
