package br.com.paraconsistente.service.impl;

import java.util.List;

import br.com.paraconsistente.dao.CFPSDao;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.service.CFPSService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cfpsService")
@Transactional
public class CPFSServiceImpl implements CFPSService {

	@Autowired
	private CFPSDao cfpsDao;

	public CFPS findById(Long id) {
		return cfpsDao.findOne(id);
	}

	public CFPS findByCPF(String cpf) {
		return cfpsDao.findByCpf(cpf);
	}

	public void saveCFPS(CFPS cfps) {
		cfpsDao.save(cfps);
	}

	public void updateCFPS(CFPS cfps) {
		saveCFPS(cfps);
	}

	public void deleteCFPSById(Long id) {
		cfpsDao.delete(id);
	}

	public void deleteAllCFPSs() {
		cfpsDao.deleteAll();
	}

	public List<CFPS> findAllCFPSs() {
		return cfpsDao.findAll();
	}

	public boolean isCFPSExist(CFPS cfps) {
		return findByCPF(cfps.getCpf()) != null;
	}

}