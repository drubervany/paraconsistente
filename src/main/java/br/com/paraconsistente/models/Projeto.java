package br.com.paraconsistente.models;

import java.util.Date;

public class Projeto {

    private Integer id;

    private GerenteProjeto gerenteProjeto;

    private String nome;

    private Cliente cliente;

    private String descricao;

    private Date dataInicio;

    private Date dataFim;

    private Integer pontosFuncao;

    private Medicao mediacao;

    public Projeto(Integer id, GerenteProjeto gerenteProjeto, String nome, Cliente cliente, String descricao, Date dataInicio, Date dataFim,
            Integer pontosFuncao, Medicao mediacao) {
        super();
        this.id = id;
        this.gerenteProjeto = gerenteProjeto;
        this.nome = nome;
        this.cliente = cliente;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.pontosFuncao = pontosFuncao;
        this.mediacao = mediacao;
    }

    public Integer getId() {
        return id;
    }

    public GerenteProjeto getGerenteProjeto() {
        return gerenteProjeto;
    }

    public String getNome() {
        return nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Integer getPontosFuncao() {
        return pontosFuncao;
    }

    public Medicao getMediacao() {
        return mediacao;
    }

}
