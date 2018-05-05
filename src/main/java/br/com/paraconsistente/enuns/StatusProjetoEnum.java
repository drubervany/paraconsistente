package br.com.paraconsistente.enuns;

import javax.persistence.Embeddable;

@Embeddable
public enum StatusProjetoEnum {
	CADASTRADO, 
	APROVADO,
	CONCLUIDO
}
