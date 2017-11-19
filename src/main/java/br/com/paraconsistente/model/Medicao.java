package br.com.paraconsistente.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICAO")
public class Medicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer ali;

	private Integer aie;

	private Integer ce;

	private Integer ee;

	private Integer se;

	private String tiposDado;

	private String tiposRegistro;

	private String arquivoReferenciado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAli() {
		return ali;
	}

	public void setAli(Integer ali) {
		this.ali = ali;
	}

	public Integer getAie() {
		return aie;
	}

	public void setAie(Integer aie) {
		this.aie = aie;
	}

	public Integer getCe() {
		return ce;
	}

	public void setCe(Integer ce) {
		this.ce = ce;
	}

	public Integer getEe() {
		return ee;
	}

	public void setEe(Integer ee) {
		this.ee = ee;
	}

	public Integer getSe() {
		return se;
	}

	public void setSe(Integer se) {
		this.se = se;
	}

	public String getTiposDado() {
		return tiposDado;
	}

	public void setTiposDado(String tiposDado) {
		this.tiposDado = tiposDado;
	}

	public String getTiposRegistro() {
		return tiposRegistro;
	}

	public void setTiposRegistro(String tiposRegistro) {
		this.tiposRegistro = tiposRegistro;
	}

	public String getArquivoReferenciado() {
		return arquivoReferenciado;
	}

	public void setArquivoReferenciado(String arquivoReferenciado) {
		this.arquivoReferenciado = arquivoReferenciado;
	}

}
