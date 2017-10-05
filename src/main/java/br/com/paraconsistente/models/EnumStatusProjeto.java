package br.com.paraconsistente.models;

public enum EnumStatusProjeto {

    CONCLUIDO(1, "Concluido"),
    ALOCADO(2, "Alocado"),
    CADASTRADO(3, "Cadastrado"),
    CRIADO(4, "Criado"),
    APROVADO(5, "Aprovado");

    private Integer id;

    private String nome;

    private EnumStatusProjeto(Integer id, String nome) {
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
