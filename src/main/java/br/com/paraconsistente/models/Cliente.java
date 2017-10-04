package br.com.paraconsistente.models;

public class Cliente {

    private Integer id;

    private String nome;

    public Cliente(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
