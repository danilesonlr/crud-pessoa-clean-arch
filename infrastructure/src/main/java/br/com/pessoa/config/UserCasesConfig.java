package br.com.pessoa.config;

import br.com.pessoa.mapper.PessoaMapper;
import br.com.pessoa.repository.PessoaDomainRepository;
import br.com.pessoa.repository.PessoaRepository;
import br.com.pessoa.repository.PessoaRepositoryImpl;
import br.com.pessoa.usecases.impl.AlterarPessoaUseCase;
import br.com.pessoa.usecases.impl.CadastrarPessoaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCasesConfig {

    @Bean
    public CadastrarPessoaUseCase cadastrarPessoaUseCase(PessoaDomainRepository pessoaDomainRepository) {
        return new CadastrarPessoaUseCase(pessoaDomainRepository);
    }

    @Bean
    public AlterarPessoaUseCase alterarPessoaUseCase(PessoaDomainRepository pessoaDomainRepository) {
        return new AlterarPessoaUseCase(pessoaDomainRepository);
    }

    @Bean
    public PessoaDomainRepository pessoaDomainRepository(PessoaRepository pessoaRepository,
                                                         PessoaMapper pessoaMapper) {
        return new PessoaRepositoryImpl(pessoaRepository, pessoaMapper);
    }
}
