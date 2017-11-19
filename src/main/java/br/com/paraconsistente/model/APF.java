package br.com.paraconsistente.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APF")
public class APF implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer aie;

	private Integer ali;

	private Integer totalPF;

	private Integer saidaExterna;

	private Integer entradaExterna;

	private Integer consultaExterna;

	private Integer totalAlta;

	private Integer totalBaixa;

	private Integer totalMedia;

	private Integer totalSE;

	private Integer totalEE;

	private Integer totalCE;

	private Integer totalALI;

	private Integer totalAIE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAie() {
		return aie;
	}

	public void setAie(Integer aie) {
		this.aie = aie;
	}

	public Integer getAli() {
		return ali;
	}

	public void setAli(Integer ali) {
		this.ali = ali;
	}

	public Integer getTotalPF() {
		return totalPF;
	}

	public void setTotalPF(Integer totalPF) {
		this.totalPF = totalPF;
	}

	public Integer getSaidaExterna() {
		return saidaExterna;
	}

	public void setSaidaExterna(Integer saidaExterna) {
		this.saidaExterna = saidaExterna;
	}

	public Integer getEntradaExterna() {
		return entradaExterna;
	}

	public void setEntradaExterna(Integer entradaExterna) {
		this.entradaExterna = entradaExterna;
	}

	public Integer getConsultaExterna() {
		return consultaExterna;
	}

	public void setConsultaExterna(Integer consultaExterna) {
		this.consultaExterna = consultaExterna;
	}

	public Integer getTotalAlta() {
		return totalAlta;
	}

	public void setTotalAlta(Integer totalAlta) {
		this.totalAlta = totalAlta;
	}

	public Integer getTotalBaixa() {
		return totalBaixa;
	}

	public void setTotalBaixa(Integer totalBaixa) {
		this.totalBaixa = totalBaixa;
	}

	public Integer getTotalMedia() {
		return totalMedia;
	}

	public void setTotalMedia(Integer totalMedia) {
		this.totalMedia = totalMedia;
	}

	public Integer getTotalSE() {
		return totalSE;
	}

	public void setTotalSE(Integer totalSE) {
		this.totalSE = totalSE;
	}

	public Integer getTotalEE() {
		return totalEE;
	}

	public void setTotalEE(Integer totalEE) {
		this.totalEE = totalEE;
	}

	public Integer getTotalCE() {
		return totalCE;
	}

	public void setTotalCE(Integer totalCE) {
		this.totalCE = totalCE;
	}

	public Integer getTotalALI() {
		return totalALI;
	}

	public void setTotalALI(Integer totalALI) {
		this.totalALI = totalALI;
	}

	public Integer getTotalAIE() {
		return totalAIE;
	}

	public void setTotalAIE(Integer totalAIE) {
		this.totalAIE = totalAIE;
	}

}
