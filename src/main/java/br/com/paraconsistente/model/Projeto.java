package br.com.paraconsistente.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PROJETO")
public class Projeto implements Serializable {

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
	private Cliente cliente;

	private String descricao;

	private Date dataInicio;

	private Date dataFim;

	private Integer pontosFuncao;

	@ManyToMany
	private List<CFPS> cfps;

	@ManyToOne
	private Medicao mediacao;

	@Enumerated(EnumType.STRING)
	private EnumStatusProjeto status;

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

	public Medicao getMediacao() {
		return mediacao;
	}

	public Long getId() {
		return id;
	}

	public EnumStatusProjeto getStatus() {
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

	public void setMediacao(Medicao mediacao) {
		this.mediacao = mediacao;
	}

	public void setStatus(EnumStatusProjeto status) {
		this.status = status;
	}

	public List<CFPS> getCfps() {
		return cfps;
	}

	public void setCfps(List<CFPS> cfps) {
		this.cfps = cfps;
	}

}
