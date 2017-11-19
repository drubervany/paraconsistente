package fr.aoufi.springboot.model;

import javax.persistence.Embeddable;

@Embeddable
public enum EnumStatusProjeto {

	CONCLUIDO, ALOCADO, CADASTRADO, CRIADO, APROVADO
}
