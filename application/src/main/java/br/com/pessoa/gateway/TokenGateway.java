package br.com.pessoa.gateway;

public interface TokenGateway {
    String generateToken(String login, String senha);

    String validateToken(String token);
}
