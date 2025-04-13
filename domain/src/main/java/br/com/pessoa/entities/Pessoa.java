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
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(telefone, pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNascimento, telefone);
    }
}
