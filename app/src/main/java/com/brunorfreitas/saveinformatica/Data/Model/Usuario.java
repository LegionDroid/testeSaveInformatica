package com.brunorfreitas.saveinformatica.Data.Model;

public class Usuario {

    private String id = String.valueOf("-1");
    private String nome, estado, sexo;

    public Usuario() {
    }

    public Usuario(String id, String nome, String estado, String sexo) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.sexo = sexo;
    }

    public Usuario(String nome, String estado, String sexo) {
        this.nome = nome;
        this.estado = estado;
        this.sexo = sexo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
