package br.com.pessoa.usecases.impl;

import br.com.pessoa.entities.Endereco;
import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.gateway.EnderecoGateway;
import br.com.pessoa.gateway.PessoaDomainGateway;
import br.com.pessoa.usecases.CadastrarPessoaUseCase;

public class CadastrarPessoaUseCaseImpl implements CadastrarPessoaUseCase {
    private final PessoaDomainGateway pessoaRepository;
    private final EnderecoGateway enderecoGateway;

    public CadastrarPessoaUseCaseImpl(PessoaDomainGateway pessoaRepository, EnderecoGateway enderecoGateway) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoGateway = enderecoGateway;
    }

    @Override
    public void salvar(Pessoa input) {
        Endereco endereco = enderecoGateway.buscarEnderecoPorCep(input.getCep());
        try {
            Pessoa pessoa = new Pessoa( input.getId(),
                    input.getNome(),
                    input.getCpf(),
                    input.getDateNascimento(),
                    input.getTelefone(),
                    input.getCep(),
                    endereco);
            pessoaRepository.salvar(pessoa);

        }catch (Exception e){
            e.getMessage();
        }

    }
}
