package br.com.paraconsistente.models;

import java.util.Date;

public class Projeto extends AbstractIdName {

    private final GerenteProjeto gerenteProjeto;

    private final Cliente cliente;

    private final String descricao;

    private final Date dataInicio;

    private Date dataFim;

    private Integer pontosFuncao;

    private Medicao mediacao;

    private EnumStatusProjeto status;

    public Projeto(Integer id, GerenteProjeto gerenteProjeto, String nome, Cliente cliente, String descricao, Date dataInicio) {
        super(id, nome);
        this.gerenteProjeto = gerenteProjeto;
        this.cliente = cliente;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
    }

    public GerenteProjeto getGerenteProjeto() {
        return gerenteProjeto;
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

    public EnumStatusProjeto getStatus() {
        return status;
    }

    public void checarIdMedicao() {

    }

}
