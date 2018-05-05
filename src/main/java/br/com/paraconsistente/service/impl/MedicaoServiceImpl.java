package br.com.paraconsistente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paraconsistente.dao.MedicaoDao;
import br.com.paraconsistente.enuns.TipoFuncaoEnum;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Medicao;
import br.com.paraconsistente.service.MedicaoService;

@Service("medicaoService")
@Transactional
public class MedicaoServiceImpl implements MedicaoService {

	@Autowired
	private MedicaoDao medicaoDao;

	public Medicao findById(Long id) {
		return medicaoDao.findOne(id);
	}

	public Medicao findByName(TipoFuncaoEnum name) {
		return medicaoDao.findByTipo(name);
	}

	public void save(Medicao cfps) {
		medicaoDao.save(cfps);
	}

	public void update(Medicao medicao) {
		save(medicao);
	}

	public void delete(Long id) {
		medicaoDao.delete(id);
	}

	public boolean isExist(Medicao medicao) {
		return findByName(medicao.getTipo()) != null;
	}
	
	@Override
	public List<Medicao> findByCfps(CFPS cfps) {
		return medicaoDao.findByCfps(cfps);
	}

	@Override
	public List<Medicao> findAll() {
		return medicaoDao.findAll();
	}

}