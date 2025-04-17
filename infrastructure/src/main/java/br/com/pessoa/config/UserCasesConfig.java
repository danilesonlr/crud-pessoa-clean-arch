package br.com.pessoa.config;

import br.com.pessoa.gateway.EnderecoGateway;
import br.com.pessoa.infrastructure.mapper.EnderecoMapper;
import br.com.pessoa.infrastructure.mapper.PessoaMapper;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.repository.EnderecoEntityRepository;
import br.com.pessoa.repository.PessoaEntityRepository;
import br.com.pessoa.service.PessoaServiceImpl;
import br.com.pessoa.usecases.*;
import br.com.pessoa.usecases.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCasesConfig {

    @Bean
    public PessoaDomainGateway pessoaDomainRepository(PessoaEntityRepository pessoaRepository,
                                                    PessoaMapper pessoaMapper) {
        return new PessoaServiceImpl(pessoaRepository, pessoaMapper);
    }

    @Bean
    public CadastrarPessoaUseCase cadastrarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository,
                                                         EnderecoGateway enderecoGateway) {
        return new CadastrarPessoaUseCaseImpl(pessoaDomainRepository, enderecoGateway);
    }

    @Bean
    public AlterarPessoaUseCase alterarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new AlterarPessoaUseCaseImpl(pessoaDomainRepository);
    }

    @Bean
    public BuscarPessoaUseCase buscarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new BuscarPessoaUseCaseImpl(pessoaDomainRepository);
    }

    @Bean
    public BuscarTodosPessoaUseCase buscarTodosPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new BuscarTodosPessoaUseCaseImpl(pessoaDomainRepository);
    }

    @Bean
    public DeletarPessoaUseCase deletarPessoaUseCase(PessoaDomainGateway pessoaDomainRepository) {
        return new DeletarPessoaUseCaseImpl(pessoaDomainRepository);
    }

}
