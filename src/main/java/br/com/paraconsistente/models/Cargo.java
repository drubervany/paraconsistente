package br.com.paraconsistente.models;

public class Cargo {

    private final Integer id;

    private final String nome;

    public Cargo(Integer id, String nome) {
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
