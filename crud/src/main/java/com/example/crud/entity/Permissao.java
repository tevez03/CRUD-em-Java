package com.example.crud.entity;

import javax.persistence.*;

@Entity
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descricao", unique = true)
    private String descricao;
    @Column(name = "ativo")
    private boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo(boolean b) {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Permissao {id=" + id +
                ", descricao='" + descricao + '\'' +
                ", ativo=" + ativo + "}";
    }
}