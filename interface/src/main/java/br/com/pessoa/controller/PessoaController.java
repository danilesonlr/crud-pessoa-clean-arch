package br.com.pessoa.controller;

import br.com.pessoa.dto.PessoaDto;
import br.com.pessoa.entities.Pessoa;
import br.com.pessoa.mapper.PessoaDtoMapper;
import br.com.pessoa.usecases.*;
import jakarta.validation.Valid;
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
    private final CadastrarPessoaUseCase cadastrarPessoaUseCase;
    private final AlterarPessoaUseCase alterarPessoaUseCase;
    private final BuscarPessoaUseCase buscarPessoaUseCase;
    private final BuscarTodosPessoaUseCase buscarTodosUseCase;
    private final DeletarPessoaUseCase detetarPessoaUseCase;
    private final PessoaDtoMapper pessoaDtoMapper;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarPessoa(@RequestBody @Valid PessoaDto pessoa){
        cadastrarPessoaUseCase.salvar(pessoaDtoMapper.toEntitie(pessoa));
    }

    @GetMapping("/buscar-todos")
    public List<Pessoa>  buscarTodos(){
        return buscarTodosUseCase.buscarTodos();
    }

    @GetMapping("/buscar/{idPessoa}")
    public Pessoa buscarPessoa(@PathVariable Long idPessoa){
        return buscarPessoaUseCase.buscarPorId(idPessoa);
    }

    @PutMapping("/alterar/{idPessoa}")
    public void alterarPessoa(@PathVariable Long idPessoa,
                              @RequestBody @Valid PessoaDto pessoa){
        alterarPessoaUseCase.alterarPessoa(pessoaDtoMapper.toEntitie(pessoa), idPessoa);
    }

    @DeleteMapping("/delete/{idPessoa}")
    public void deletarPesso(@PathVariable Long idPessoa){
        detetarPessoaUseCase.deletarPorId(idPessoa);
    }

}
