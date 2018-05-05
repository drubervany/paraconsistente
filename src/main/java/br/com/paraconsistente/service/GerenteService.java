package br.com.paraconsistente.service;


import java.util.List;

import br.com.paraconsistente.model.Gerente;

public interface GerenteService {
	
	Gerente findById(Long id);

	void saveGerente(Gerente gerente);

	void updateGerente(Gerente gerente);

	void deleteGerenteById(Long id);

	void deleteAllGerentes();

	List<Gerente> findAllGerentes();

	boolean isGerenteExist(Gerente gerente);

}