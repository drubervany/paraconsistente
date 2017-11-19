package fr.aoufi.springboot.service;


import java.util.List;

import fr.aoufi.springboot.model.Projeto;

public interface ProjetoService {
	
	Projeto findById(Long id);

	Projeto findByName(String name);

	void saveProjeto(Projeto projeto);

	void updateProjeto(Projeto projeto);

	void deleteProjetoById(Long id);

	void deleteAllProjetos();

	List<Projeto> findAllProjetos();

	boolean isProjetoExist(Projeto Projeto);
}