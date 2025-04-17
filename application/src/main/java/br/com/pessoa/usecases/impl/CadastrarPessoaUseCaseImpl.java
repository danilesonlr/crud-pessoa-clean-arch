package br.com.pessoa.usecases.impl;

import br.com.pessoa.entities.Endereco;
import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.gateway.EnderecoGateway;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.usecases.CadastrarPessoaUseCase;
import exception.BusinessValidateException;
import exception.enums.ErroCodeEnum;

public class CadastrarPessoaUseCaseImpl implements CadastrarPessoaUseCase {
    private final PessoaDomainGateway pessoaRepository;
    private final EnderecoGateway enderecoGateway;

    public CadastrarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository, EnderecoGateway enderecoGateway) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoGateway = enderecoGateway;
    }

    @Override
    public void salvar(Pessoa input) {
        Endereco endereco = getEndereco(input);
        Pessoa pessoa = new Pessoa( input.getId(),
                input.getNome(),
                input.getCpf(),
                input.getDateNascimento(),
                input.getTelefone(),
                input.getCep(),
                endereco);
        pessoaRepository.salvar(pessoa);
    }

    private Endereco getEndereco(Pessoa input) {
        Endereco endereco = null;
        try {
            endereco = enderecoGateway.buscarEnderecoPorCep(input.getCep());
            if (endereco == null) {
                throw new BusinessValidateException(ErroCodeEnum.UC0001.getCode(),
                        ErroCodeEnum.UC0001.getMessage());
            }
        } catch (BusinessValidateException ex) {
            throw ex;
        } catch (Exception e) {
            throw new BusinessValidateException(ErroCodeEnum.UC0002.getCode(),
                    ErroCodeEnum.UC0002.getMessage());
        }
        return endereco;
    }
}
