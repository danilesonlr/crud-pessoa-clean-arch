package br.com.pessoa.dto;

import java.time.LocalDate;
import java.util.Objects;

public class PessoaDto {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;


    public PessoaDto() {
    }

    public PessoaDto(String nome, String cpf, LocalDate dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDto pessoaDto = (PessoaDto) o;
        return Objects.equals(id, pessoaDto.id) && Objects.equals(nome, pessoaDto.nome) && Objects.equals(cpf, pessoaDto.cpf) && Objects.equals(dataNascimento, pessoaDto.dataNascimento) && Objects.equals(telefone, pessoaDto.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNascimento, telefone);
    }
}