package br.com.paraconsistente.service;


import java.util.List;

import br.com.paraconsistente.enuns.StatusProjetoEnum;
import br.com.paraconsistente.model.Projeto;

public interface ProjetoService {
	
	Projeto findById(Long id);

	Projeto findByName(String name);

	void saveProjeto(Projeto projeto);

	void updateProjeto(Projeto projeto);

	void deleteProjetoById(Long id);

	void deleteAllProjetos();

	List<Projeto> findAllProjetos();

	boolean isProjetoExist(Projeto Projeto);

	List<Projeto> findByStatus(StatusProjetoEnum status);
}