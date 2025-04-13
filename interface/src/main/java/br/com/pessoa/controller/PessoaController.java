package br.com.pessoa.controller;

import br.com.pessoa.dto.PessoaDto;
import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.repository.PessoaRepositoryImpl;
import br.com.pessoa.usecases.impl.AlterarPessoaUseCase;
import br.com.pessoa.usecases.impl.CadastrarPessoaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaRepositoryImpl service;
    private final CadastrarPessoaUseCase cadastrarPessoaUseCase;
    private final AlterarPessoaUseCase alterarPessoaUseCase;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarPessoa(@RequestBody PessoaDto pessoa){
        cadastrarPessoaUseCase.execute(pessoa, null);
    }

    @GetMapping("/buscar-todos")
    public List<Pessoa>  buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/buscar/{idPessoa}")
    public Pessoa buscarPessoa(@PathVariable Long idPessoa){
        return service.buscarPorId(idPessoa);
    }

    @PutMapping("/alterar/{idPessoa}")
    public void alterarPessoa(@PathVariable Long idPessoa,
                              @RequestBody PessoaDto pessoa){
        alterarPessoaUseCase.execute(pessoa, idPessoa);
    }

    @DeleteMapping("/delete/{idPessoa}")
    public void deletarPesso(@PathVariable Long idPessoa){
        service.deletarPorId(idPessoa);
    }

}
