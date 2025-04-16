package br.com.pessoa.mapper;

import br.com.pessoa.dto.PessoaDto;
import br.com.pessoa.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaDtoMapper  {


    PessoaDto toDto(Pessoa entitie);

    @Mapping(target = "id", ignore = true) //ignorando campo ID
        //@Mapping(source = "name", target = "username") //e possivel mapear os campos caso seja diferentes.
    Pessoa toEntitie(PessoaDto pessoa);
}
