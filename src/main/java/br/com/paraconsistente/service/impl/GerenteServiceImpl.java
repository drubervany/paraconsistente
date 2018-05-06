package br.com.paraconsistente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paraconsistente.dao.GerenteDao;
import br.com.paraconsistente.model.Gerente;
import br.com.paraconsistente.service.GerenteService;

@Service("gerenteService")
@Transactional
public class GerenteServiceImpl implements GerenteService {

	@Autowired
	private GerenteDao gerenteDao;

	public Gerente findById(Long id) {
		return gerenteDao.findOne(id);
	}
	
	public Gerente findByCpf(String cpf) {
		return gerenteDao.findByCpf(cpf);
	}

	public void saveGerente(Gerente gerente) {
		gerenteDao.save(gerente);
	}

	public void updateGerente(Gerente gerente) {
		saveGerente(gerente);
	}

	public void deleteGerenteById(Long id) {
		gerenteDao.delete(id);
	}

	public void deleteAllGerentes() {
		gerenteDao.deleteAll();
	}

	public List<Gerente> findAllGerentes() {
		return gerenteDao.findAll();
	}

	@Override
	public boolean isGerenteExist(Gerente gerente) {
		return findByCpf(gerente.getCpf()) != null;
	}
}