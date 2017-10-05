package br.com.paraconsistente.models;

public class CFPS extends AbstractIdName {

    private Projeto projeto;

    private Integer numeroPontos;

    private Medicao medicao;

    public CFPS(Integer id, String nome, Projeto projeto, Integer numeroPontos, Medicao medicao) {
        super(id, nome);
        this.projeto = projeto;
        this.numeroPontos = numeroPontos;
        this.medicao = medicao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public Integer getNumeroPontos() {
        return numeroPontos;
    }

    public Medicao getMedicao() {
        return medicao;
    }

}
