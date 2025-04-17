package br.com.pessoa.service;

import br.com.pessoa.entities.Endereco;
import br.com.pessoa.gateway.EnderecoGateway;
import br.com.pessoa.integration.ViaCepClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoServiceImpl implements EnderecoGateway {
    private final ViaCepClient viaCepClient;

    @Override
    public Endereco buscarEnderecoPorCep(String cep) {
        try {
            return viaCepClient.buscar(cep);
        } catch (Exception e){
            log.error("Falha na busca do CEP: {}", e.getMessage());
            return null;
        }
    }
}
