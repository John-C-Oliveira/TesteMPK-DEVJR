package br.com.JohnOliveira.TesteMPK.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank(message = "O Nome é obrigatório!")
    private String nome;

    @NotNull(message = "O Cnpj é obrigatório")
    private Long cnpj;

    @NotNull(message = "A Idade é obrigatória")
    @Min(value = 18,message = "Não é possível cadastrar um cliente menor de 18 anos")
    private int idade;

    @NotNull(message = "Preencha a data de nascimento no formato dd/mm/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    public Cliente( String nome, Long cnpj, int idade, Date dataNascimento) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
