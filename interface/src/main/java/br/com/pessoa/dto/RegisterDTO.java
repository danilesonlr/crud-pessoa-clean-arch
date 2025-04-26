package br.com.pessoa.dto;

import br.com.pessoa.entity.acesso.enums.AcessoRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterDTO {
    private String login;
    private String senha;
    private AcessoRoleEnum Role;
}
