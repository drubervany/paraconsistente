package br.com.paraconsistente.service;


import java.util.List;

import br.com.paraconsistente.model.Funcao;

public interface FuncaoService {
	
	Funcao findById(Long id);

	Funcao findByName(String name);

	void save(Funcao funcao);

	void update(Funcao funcao);

	void delete(Long id);

	boolean isExist(Funcao funcao);

	List<Funcao> findAll();
}