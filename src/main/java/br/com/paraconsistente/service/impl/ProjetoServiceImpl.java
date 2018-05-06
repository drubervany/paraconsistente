package br.com.paraconsistente.service.impl;

import java.util.List;

import br.com.paraconsistente.dao.ProjetoDao;
import br.com.paraconsistente.enuns.StatusProjetoEnum;
import br.com.paraconsistente.model.Projeto;
import br.com.paraconsistente.service.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("projetoService")
@Transactional
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoDao projetoDao;

	public Projeto findById(Long id) {
		return projetoDao.findOne(id);
	}

	public Projeto findByName(String name) {
		return projetoDao.findByNome(name);
	}

	public void saveProjeto(Projeto projeto) {
		projetoDao.save(projeto);
	}

	public void updateProjeto(Projeto projeto) {
		saveProjeto(projeto);
	}

	public void deleteProjetoById(Long id) {
		projetoDao.delete(id);
	}

	public void deleteAllProjetos() {
		projetoDao.deleteAll();
	}

	public List<Projeto> findAllProjetos() {
		return projetoDao.findAll();
	}

	public boolean isProjetoExist(Projeto projeto) {
		return findByName(projeto.getNome()) != null;
	}

	@Override
	public List<Projeto> findByStatus(StatusProjetoEnum status) {
		return projetoDao.findByStatus(status);
	}

}