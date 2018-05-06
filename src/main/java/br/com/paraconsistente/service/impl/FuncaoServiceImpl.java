package br.com.paraconsistente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paraconsistente.dao.FuncaoDao;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Funcao;
import br.com.paraconsistente.model.Projeto;
import br.com.paraconsistente.service.FuncaoService;

@Service("funcaoService")
@Transactional
public class FuncaoServiceImpl implements FuncaoService {

	@Autowired
	private FuncaoDao funcaoDao;

	public Funcao findById(Long id) {
		return funcaoDao.findOne(id);
	}

	public Funcao findByName(String name) {
		return funcaoDao.findByNome(name);
	}

	public void save(Funcao cfps) {
		funcaoDao.save(cfps);
	}

	public void update(Funcao funcao) {
		save(funcao);
	}

	public void delete(Long id) {
		funcaoDao.delete(id);
	}

	public boolean isExist(Funcao funcao) {
		return findByName(funcao.getNome()) != null;
	}

	@Override
	public List<Funcao> findAll() {
		return funcaoDao.findAll();
	}

	@Override
	public List<Funcao> findByProjetoAndCfps(Projeto projeto, CFPS cfps) {
		return funcaoDao.findByProjetoAndCfps(projeto, cfps);
	}

}