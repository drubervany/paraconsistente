package br.com.paraconsistente.service.impl;

import java.util.List;

import br.com.paraconsistente.dao.EnterpriseDao;
import br.com.paraconsistente.model.Enterprise;
import br.com.paraconsistente.service.EnterpriseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("enterpriseService")
@Transactional
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private EnterpriseDao enterpriseDao;

	public Enterprise findById(Long id) {
		return enterpriseDao.findOne(id);
	}

	public Enterprise findByName(String name) {
		return enterpriseDao.findByName(name);
	}

	public void saveEnterprise(Enterprise enterprise) {
		enterpriseDao.save(enterprise);
	}

	public void updateEnterprise(Enterprise enterprise) {
		saveEnterprise(enterprise);
	}

	public void deleteEnterpriseById(Long id) {
		enterpriseDao.delete(id);
	}

	public void deleteAllEnterprises() {
		enterpriseDao.deleteAll();
	}

	public List<Enterprise> findAllEnterprises() {
		return enterpriseDao.findAll();
	}

	public boolean isEnterpriseExist(Enterprise enterprise) {
		return findByName(enterprise.getName()) != null;
	}

}