package br.com.pessoa.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;

public class Pessoa {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private Endereco endereco;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String cpf, LocalDate dateNascimento, String telefone) {
        if (nome.isBlank()) throw new IllegalArgumentException("Nome é obrigatório.");
        if (telefone.isBlank()) throw new IllegalArgumentException("Telefone é obrigatório.");
        if (cpf.isBlank()) throw new IllegalArgumentException("CPF é obrigatório.");
        if (dateNascimento == null) throw new IllegalArgumentException("Data de nascimento é obrigatória.");

        if (!validarIdade(dateNascimento)) throw new IllegalArgumentException("Funcionário deve ser maior de 18 anos.");

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dateNascimento;
        this.telefone = telefone;
    }

    private boolean validarIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears() >= 18;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
