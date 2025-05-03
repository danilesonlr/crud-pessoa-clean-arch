package br.com.pessoa.auth.service;

import br.com.pessoa.gateway.TokenGateway;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import exception.BusinessValidateException;
import exception.enums.ErroCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenGateway {
    @Value("${api.securiy.token}")
    private String secret;

    @Override
    public String generateToken(String login, String senha) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token = JWT.create()
                    .withIssuer("crud-pessoa-clean-arch") //QUEN ESTÁ CRIANDO O TOKEN
                    .withSubject(login) // USUARIO QUE ESTÁ GERANDO O TOKEN
                    .withExpiresAt(genExperitaionDate()) //HORA DE ESPIRAÇÃO DO TOKEN
                    .sign(algorithm); // ALGORITIMO GERADOR DO TOKEN
        }catch (JWTCreationException e) {
            throw new BusinessValidateException(ErroCodeEnum.AUT0002.getMessage(),
                    ErroCodeEnum.AUT0002.getCode());
        }
        return token;
    }

    @Override
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("crud-pessoa-clean-arch") //QUEN ESTÁ CRIANDO O TOKEN
                    .build()
                    .verify(token) //TOKEN A SER VALIDADO
                    .getSubject(); //RECUPERAR O USUÁRIO
        }catch (JWTCreationException e) {
            return null;
        }
    }

    private Instant genExperitaionDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
