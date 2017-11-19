package br.com.paraconsistente.service;


import java.util.List;

import br.com.paraconsistente.model.Enterprise;

public interface EnterpriseService {
	
	Enterprise findById(Long id);

	Enterprise findByName(String name);

	void saveEnterprise(Enterprise enterprise);

	void updateEnterprise(Enterprise enterprise);

	void deleteEnterpriseById(Long id);

	void deleteAllEnterprises();

	List<Enterprise> findAllEnterprises();

	boolean isEnterpriseExist(Enterprise enterprise);
}