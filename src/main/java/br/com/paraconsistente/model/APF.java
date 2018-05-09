package br.com.paraconsistente.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APF")
public class APF implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private CFPS cfps;

	private Integer ali;

	private Integer aie;

	private Integer se;

	private Integer ee;

	private Integer ce;

	private Integer pontoFuncao;

	private Integer tr;

	private Integer td;

	public Long getId() {
		return id;
	}

	public CFPS getCfps() {
		return cfps;
	}

	public Integer getAli() {
		return ali;
	}

	public Integer getAie() {
		return aie;
	}

	public Integer getSe() {
		return se;
	}

	public Integer getEe() {
		return ee;
	}

	public Integer getCe() {
		return ce;
	}

	public Integer getPontoFuncao() {
		return pontoFuncao;
	}

	public Integer getTr() {
		return tr;
	}

	public Integer getTd() {
		return td;
	}

}
