package br.com.paraconsistente.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.paraconsistente.enuns.StatusMedicaoEnum;

@Entity
@Table(name = "PROJETO_CFPS")
public class ProjetoCfps implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	private Projeto projeto;

	@Id
	@ManyToOne
	private CFPS cfpss;

	@Enumerated(EnumType.STRING)
	private StatusMedicaoEnum status;

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public CFPS getCfpss() {
		return cfpss;
	}

	public void setCfpss(CFPS cfpss) {
		this.cfpss = cfpss;
	}

	public StatusMedicaoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusMedicaoEnum status) {
		this.status = status;
	}
}
