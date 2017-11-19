package br.com.paraconsistente.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LPA")
public class LPA implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal peso;

	private BigDecimal baricentro;

	private BigDecimal resultante;

	private BigDecimal grauIncerteza;

	private BigDecimal grauCerteza;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getBaricentro() {
		return baricentro;
	}

	public void setBaricentro(BigDecimal baricentro) {
		this.baricentro = baricentro;
	}

	public BigDecimal getResultante() {
		return resultante;
	}

	public void setResultante(BigDecimal resultante) {
		this.resultante = resultante;
	}

	public BigDecimal getGrauIncerteza() {
		return grauIncerteza;
	}

	public void setGrauIncerteza(BigDecimal grauIncerteza) {
		this.grauIncerteza = grauIncerteza;
	}

	public BigDecimal getGrauCerteza() {
		return grauCerteza;
	}

	public void setGrauCerteza(BigDecimal grauCerteza) {
		this.grauCerteza = grauCerteza;
	}

}
