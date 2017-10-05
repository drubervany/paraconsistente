package br.com.paraconsistente.models;

public class AbstractIdName {

    private Integer id;

    private String nome;

    public AbstractIdName(Integer id, String nome) {
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
