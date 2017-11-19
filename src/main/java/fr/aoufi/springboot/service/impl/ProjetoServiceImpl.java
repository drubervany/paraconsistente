package fr.aoufi.springboot.service.impl;

import java.util.List;

import fr.aoufi.springboot.dao.ProjetoDao;
import fr.aoufi.springboot.model.Projeto;
import fr.aoufi.springboot.service.ProjetoService;

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

}