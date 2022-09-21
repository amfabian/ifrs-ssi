package com.example.desafio2progweb3.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity
public class Cafe implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String descricao;
    private String preco;
    private boolean contemLactose;
    private String ingredientes;

    public Cafe() {};


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public boolean isContemLactose() {
        return contemLactose;
    }

    public void setContemLactose(boolean contemLactose) {
        this.contemLactose = contemLactose;
    }

    public String getContemLcatose(){
        String contem;
        if(isContemLactose()) contem = "Sim";
        else contem = "Não";
        return contem;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "_id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco='" + preco + '\'' +
                ", contemLactose=" + contemLactose +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
