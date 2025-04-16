package br.com.pessoa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ENDERECO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnderecoEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "LOUGRADOURO")
    private String logradouro;
    @Column(name = "UF")
    private String uf;
    @Column(name = "CIDADE")
    private String cidade;

}
