package br.com.paraconsistente.service;


import java.util.List;

import br.com.paraconsistente.model.CFPS;

public interface CFPSService {
	
	CFPS findById(Long id);

	CFPS findByCPF(String cpf);

	void saveCFPS(CFPS cfps);

	void updateCFPS(CFPS cfps);

	void deleteCFPSById(Long id);

	void deleteAllCFPSs();

	List<CFPS> findAllCFPSs();

	boolean isCFPSExist(CFPS CFPS);

	CFPS findByCNPJ(String cnpj);
}