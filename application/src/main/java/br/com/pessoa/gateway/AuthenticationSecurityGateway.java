package br.com.pessoa.gateway;


public interface AuthenticationSecurityGateway {
     String authentication(String login, String senha);

     void register(String login, String senha, String role);

}
