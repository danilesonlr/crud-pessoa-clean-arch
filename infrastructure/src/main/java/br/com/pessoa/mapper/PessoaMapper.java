package br.com.pessoa.mapper;

import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.entity.PessoaEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final ModelMapper modelMapper;

    public Pessoa toEntity(PessoaEntity entity) {
        return entity == null ? null : modelMapper.map(entity, Pessoa.class);
    }

    public PessoaEntity toDTO(Pessoa pessoa) {
        return pessoa == null ? null : modelMapper.map(pessoa, PessoaEntity.class);
    }
}
