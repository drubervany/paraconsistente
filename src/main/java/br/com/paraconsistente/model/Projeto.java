package br.com.paraconsistente.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.paraconsistente.enuns.StatusProjetoEnum;

@Entity
@Table(name = "PROJETO")
public class Projeto implements Serializable {

	private static final double NIVEL_EXIGENCIA = 0.55;

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String nome;

	@ManyToOne
	private Gerente gerente;

	@ManyToOne
	private Gerente gerenteBackup;

	@ManyToOne
	private Cliente cliente;

	private String descricao;

	private Date dataInicio;

	private Date dataFim;

	@Enumerated(EnumType.STRING)
	private StatusProjetoEnum status;

	@ManyToMany
	private List<CFPS> cfpss;

	@ManyToOne
	private CFPS cfps;

	@ManyToOne(cascade = CascadeType.ALL)
	private CFPS cfpsIA;

	private Integer pontosFuncao;

	private String Resultante;

	private double gce;

	private double gco;

	public Gerente getGerente() {
		return gerente;
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

	public Long getId() {
		return id;
	}

	public StatusProjetoEnum getStatus() {
		return status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public void setPontosFuncao(Integer pontosFuncao) {
		this.pontosFuncao = pontosFuncao;
	}

	public void setStatus(StatusProjetoEnum status) {
		this.status = status;
	}

	public List<CFPS> getCfpss() {
		return cfpss;
	}

	public void setCfpss(List<CFPS> cfps) {
		this.cfpss = cfps;
	}

	public CFPS getCfps() {
		return cfps;
	}

	public void setCfps(CFPS cfpsSelecionado) {
		this.cfps = cfpsSelecionado;
	}

	public CFPS getCfpsIA() {
		return cfpsIA;
	}

	public void setCfpsIA(CFPS cfpsIA) {
		this.cfpsIA = cfpsIA;
	}

	public Gerente getGerenteBackup() {
		return gerenteBackup;
	}

	public void setGerenteBackup(Gerente gerenteBackup) {
		this.gerenteBackup = gerenteBackup;
	}

	public String getResultante() {
		return Resultante;
	}

	public void setResultante(String resultante) {
		Resultante = resultante;
	}

	public double getGco() {
		return gco;
	}

	public void setGco(double gco) {
		this.gco = gco;
	}

	public double getGce() {
		return gce;
	}

	public void setGce(double gce) {
		this.gce = gce;
	}

	@JsonProperty
	public String getAnaliseGlobal() {
		if (this.gce == 0)
			return null;
		return this.gce <= NIVEL_EXIGENCIA ? "Recontar Projeto" : "Fazer Projeto";
	}

	@JsonProperty
	public String getGeral() {
		if (this.gce == 0 && this.gco == 0)
			return null;
		return this.gce <= NIVEL_EXIGENCIA ? "INVIÁVEL" : this.gco >= NIVEL_EXIGENCIA ? "VIÁVEL" : "NÃO CONCLUSIVO";
	}
}
