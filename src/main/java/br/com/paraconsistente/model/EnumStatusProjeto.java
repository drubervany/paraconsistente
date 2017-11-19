package br.com.paraconsistente.model;

import javax.persistence.Embeddable;

@Embeddable
public enum EnumStatusProjeto {

	CONCLUIDO, ALOCADO, CADASTRADO, CRIADO, APROVADO
}
