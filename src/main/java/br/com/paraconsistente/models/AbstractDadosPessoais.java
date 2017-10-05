package br.com.paraconsistente.models;

public class AbstractDadosPessoais extends AbstractIdName {

    private final String cpf;

    private final String email;

    public AbstractDadosPessoais(Integer id, String nome, String cpf, String email) {
        super(id, nome);
        this.cpf = cpf;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

}
