package br.com.paraconsistente.models;

public class CFPS {

    private Especialista especialista;

    private Projeto projeto;

    private Integer numeroPontos;

    private Medicao medicao;

    public CFPS(Especialista especialista, Projeto projeto, Integer numeroPontos, Medicao medicao) {
        this.especialista = especialista;
        this.projeto = projeto;
        this.numeroPontos = numeroPontos;
        this.medicao = medicao;
    }

    public Especialista getEspecialista() {
        return especialista;
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
