package fr.aoufi.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NORMALIZADOR")
public class Normalizador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal minino;

	private BigDecimal maximo;

	private BigDecimal minimoGrauFavoravel;

	private BigDecimal minimoGrauDesfavoravel;

	private BigDecimal maximoGrauFavoravel;

	private BigDecimal maximoGrauDesfavoravel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMinino() {
		return minino;
	}

	public void setMinino(BigDecimal minino) {
		this.minino = minino;
	}

	public BigDecimal getMaximo() {
		return maximo;
	}

	public void setMaximo(BigDecimal maximo) {
		this.maximo = maximo;
	}

	public BigDecimal getMinimoGrauFavoravel() {
		return minimoGrauFavoravel;
	}

	public void setMinimoGrauFavoravel(BigDecimal minimoGrauFavoravel) {
		this.minimoGrauFavoravel = minimoGrauFavoravel;
	}

	public BigDecimal getMinimoGrauDesfavoravel() {
		return minimoGrauDesfavoravel;
	}

	public void setMinimoGrauDesfavoravel(BigDecimal minimoGrauDesfavoravel) {
		this.minimoGrauDesfavoravel = minimoGrauDesfavoravel;
	}

	public BigDecimal getMaximoGrauFavoravel() {
		return maximoGrauFavoravel;
	}

	public void setMaximoGrauFavoravel(BigDecimal maximoGrauFavoravel) {
		this.maximoGrauFavoravel = maximoGrauFavoravel;
	}

	public BigDecimal getMaximoGrauDesfavoravel() {
		return maximoGrauDesfavoravel;
	}

	public void setMaximoGrauDesfavoravel(BigDecimal maximoGrauDesfavoravel) {
		this.maximoGrauDesfavoravel = maximoGrauDesfavoravel;
	}

}
