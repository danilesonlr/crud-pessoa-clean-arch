package br.com.pessoa.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;

public class Pessoa {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dateNascimento;
    private String telefone;
    private String cep;
    private Endereco endereco;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String cpf, LocalDate dateNascimento, String telefone, String cep,
                  Endereco endereco) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome é obrigatório.");
        if (telefone == null || telefone.isBlank()) throw new IllegalArgumentException("Telefone é obrigatório.");
        if (cpf == null || cpf.isBlank()) throw new IllegalArgumentException("CPF é obrigatório.");
        if (dateNascimento == null)
            throw new IllegalArgumentException("Data de nascimento é obrigatória.");
        if (cep == null || cep.isBlank()) throw new IllegalArgumentException("CEP é obrigatório.");


        if (!validarIdade(dateNascimento)) throw new IllegalArgumentException("Funcionário deve ser maior de 18 anos.");

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dateNascimento = dateNascimento;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
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

    public LocalDate getDateNascimento() {
        return dateNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
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

    public void setDateNascimento(LocalDate dateNascimento) {
        this.dateNascimento = dateNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
