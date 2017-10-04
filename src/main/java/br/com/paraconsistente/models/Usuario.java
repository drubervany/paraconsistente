package br.com.paraconsistente.models;

public class Usuario {

    private Integer id;

    private Cargo cargo;

    private String nome;

    private Long cpf;

    private String senha;

    private String email;

    public Usuario(Integer id, Cargo cargo, String nome, Long cpf, String senha, String email) {
        super();
        this.id = id;
        this.cargo = cargo;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

}
