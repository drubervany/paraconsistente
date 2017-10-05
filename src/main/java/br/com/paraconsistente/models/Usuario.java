package br.com.paraconsistente.models;

public class Usuario extends AbstractIdName {

    private Cargo cargo;

    private Long cpf;

    private String senha;

    private String email;

    public Usuario(Integer id, Cargo cargo, String nome, Long cpf, String senha, String email) {
        super(id, nome);
        this.cargo = cargo;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }

    public Cargo getCargo() {
        return cargo;
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
