package br.com.paraconsistente.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.paraconsistente.enuns.StatusMedicaoEnum;
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
	
	@Enumerated(EnumType.STRING)
	private StatusMedicaoEnum status;

	private Integer qtdeDados = 0;

	private Integer qtdeRegistros = 0;

	private Integer totalPonfoFuncao = 0;

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

	public Integer getTotalPonfoFuncao() {

		Map<String, Integer> ali = new HashMap<>();
		ali.put("1", 7);
		ali.put("2", 10);
		ali.put("3", 15);

		Map<String, Integer> aie = new HashMap<>();
		aie.put("1", 5);
		aie.put("2", 7);
		aie.put("3", 10);

		Map<String, Integer> se = new HashMap<>();
		se.put("1", 4);
		se.put("2", 5);
		se.put("3", 7);

		Map<String, Integer> ee = new HashMap<>();
		ee.put("1", 3);
		ee.put("2", 4);
		ee.put("3", 6);

		Map<String, Integer> ce = new HashMap<>();
		ce.put("1", 3);
		ce.put("2", 4);
		ce.put("3", 6);

		List<Complexidade> complexidade = Arrays.asList(
				new Complexidade(1, 1,
						Arrays.asList(new TipoDados(1, 19, 1), new TipoDados(20, 50, 1), new TipoDados(51, 999, 2))),
				new Complexidade(2, 5,
						Arrays.asList(new TipoDados(1, 19, 1), new TipoDados(20, 50, 2), new TipoDados(51, 999, 3))),
				new Complexidade(6, 999,
						Arrays.asList(new TipoDados(1, 19, 2), new TipoDados(20, 50, 3), new TipoDados(51, 999, 3))));

		complexidade.forEach(tipoRegistro -> {
			if (this.qtdeRegistros >= tipoRegistro.inicio && this.qtdeRegistros <= tipoRegistro.fim) {

				tipoRegistro.tipoDados.forEach(tipoDados -> {
					if (this.qtdeDados >= tipoDados.inicio && this.qtdeDados <= tipoDados.fim) {

						if ("ALI".equals(this.tipo.name())) {
							this.totalPonfoFuncao = ali.get(tipoDados.resultado.toString());
						} else if ("AIE".equals(this.tipo.name())) {
							this.totalPonfoFuncao = aie.get(tipoDados.resultado.toString());
						} else if ("EE".equals(this.tipo.name())) {
							this.totalPonfoFuncao = ee.get(tipoDados.resultado.toString());
						} else if ("SE".equals(this.tipo.name())) {
							this.totalPonfoFuncao = se.get(tipoDados.resultado.toString());
						} else if ("CE".equals(this.tipo.name())) {
							this.totalPonfoFuncao = ce.get(tipoDados.resultado.toString());
						}
					}
				});
			}
		});
		return this.totalPonfoFuncao;
	}

	public StatusMedicaoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusMedicaoEnum status) {
		this.status = status;
	}

}

class Complexidade {

	Integer inicio;
	Integer fim;
	List<TipoDados> tipoDados;

	public Complexidade(Integer inicio, Integer fim, List<TipoDados> tipoDados) {
		this.inicio = inicio;
		this.fim = fim;
		this.tipoDados = tipoDados;
	}
}

class TipoDados {

	Integer inicio;
	Integer fim;
	Integer resultado;

	public TipoDados(Integer inicio, Integer fim, Integer resultado) {
		this.inicio = inicio;
		this.fim = fim;
		this.resultado = resultado;
	}
}
