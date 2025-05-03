package br.com.pessoa.auth.service;

import br.com.pessoa.entity.acesso.AcessoEntity;
import br.com.pessoa.entity.acesso.enums.AcessoRoleEnum;
import br.com.pessoa.gateway.AuthenticationSecurityGateway;
import br.com.pessoa.repository.AcessorEntityRepository;
import exception.BusinessValidateException;
import exception.enums.ErroCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationSecurityServiceImpl implements AuthenticationSecurityGateway {

    private final AuthenticationManager authenticationManager;
    private final AcessorEntityRepository acessorEntityRepository;
    private final TokenServiceImpl tokenService;

    @Override
    public String authentication(String login, String senha){
        var usernamePassword = new UsernamePasswordAuthenticationToken(login, senha);
        var auth = authenticationManager.authenticate(usernamePassword);
        AcessoEntity user = (AcessoEntity) auth.getPrincipal();
        return tokenService.generateToken(user.getUsername(), user.getPassword());
    }

    @Override
    public void register(String login, String passaword, String role) {
        if(this.acessorEntityRepository.findByLogin(login).isPresent()){
            throw new BusinessValidateException(ErroCodeEnum.AUT0001.getMessage(), ErroCodeEnum.AUT0001.getCode());
        }
        String encryptePassword = new BCryptPasswordEncoder().encode(passaword);
        AcessoEntity acesso = AcessoEntity.builder()
                .login(login)
                .passaword(encryptePassword)
                .role(AcessoRoleEnum.valueOf(role))
                .build();
        acessorEntityRepository.save(acesso);
    }
}
