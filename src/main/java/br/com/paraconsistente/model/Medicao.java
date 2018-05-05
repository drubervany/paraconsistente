package br.com.paraconsistente.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.paraconsistente.enuns.TipoFuncaoEnum;

@Entity
@Table(name = "MEDICAO")
public class Medicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Projeto projeto;
	
	@ManyToOne
	private CFPS cfps;

	@ManyToOne
	private Funcao funcao;

	@Enumerated(EnumType.STRING)
	private TipoFuncaoEnum tipo;

	private Integer qtdeDados;

	private Integer qtdeRegistros;

	private Integer totalPonfoFuncao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoFuncaoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncaoEnum tipo) {
		this.tipo = tipo;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Integer getQtdeDados() {
		return qtdeDados;
	}

	public void setQtdeDados(Integer qtdeDados) {
		this.qtdeDados = qtdeDados;
	}

	public Integer getQtdeRegistros() {
		return qtdeRegistros;
	}

	public void setQtdeRegistros(Integer qtdeRegistros) {
		this.qtdeRegistros = qtdeRegistros;
	}

	public Integer getTotalPonfoFuncao() {
		return totalPonfoFuncao;
	}

	public void setTotalPonfoFuncao(Integer totalPonfoFuncao) {
		this.totalPonfoFuncao = totalPonfoFuncao;
	}

	public CFPS getCfps() {
		return cfps;
	}

	public void setCfps(CFPS cfps) {
		this.cfps = cfps;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
