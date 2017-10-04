package br.com.paraconsistente.models;

public class GerenteProjeto {

    private final Integer id;

    private final String nome;

    private final String cpf;

    private final String email;

    public GerenteProjeto(Integer id, String nome, String cpf, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

}
