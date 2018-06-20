package br.com.paraconsistente.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.paraconsistente.enuns.TipoContadorEnum;

@Entity
@Table(name = "CFPS")
public class CFPS implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	//@CPF
	private String cpf;
	
	//@CNPJ
	private String cnpj;

	@Email
	private String email;

	private Integer numeroPontos = 0;
	
	private BigDecimal favoravel = BigDecimal.ZERO;
	
	private BigDecimal desfavoravel = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	private TipoContadorEnum contador;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeroPontos() {
		return numeroPontos;
	}

	public void setNumeroPontos(Integer numeroPontos) {
		this.numeroPontos = numeroPontos;
	}

	public BigDecimal getFavoravel() {
		return favoravel;
	}

	public void setFavoravel(BigDecimal favoravel) {
		this.favoravel = favoravel;
	}

	public BigDecimal getDesfavoravel() {
		return desfavoravel;
	}

	public void setDesfavoravel(BigDecimal desfavoravel) {
		this.desfavoravel = desfavoravel;
	}
	
	public TipoContadorEnum getContador() {
		return contador;
	}

	public void setContador(TipoContadorEnum contador) {
		this.contador = contador;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
