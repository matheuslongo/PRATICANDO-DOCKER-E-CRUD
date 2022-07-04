package br.com.crudspringmysql.springbootcommysql.controller.dto;

public class Pessoarq {
    private String nome;
    private String sobrenom;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenom() {
        return sobrenom;
    }

    public void setSobrenom(String sobrenom) {
        this.sobrenom = sobrenom;
    }
}
