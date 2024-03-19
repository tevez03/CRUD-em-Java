package com.example.crud.dto;

public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private int idade;
    private String email;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {return nome;}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                '}';
    }
}
