package br.com.paraconsistente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paraconsistente.dao.ProjetoDao;
import br.com.paraconsistente.enuns.StatusProjetoEnum;
import br.com.paraconsistente.enuns.TipoContadorEnum;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Cliente;
import br.com.paraconsistente.model.Projeto;
import br.com.paraconsistente.service.CFPSService;
import br.com.paraconsistente.service.NormalizacaoService;
import br.com.paraconsistente.service.ProjetoService;

@Service("projetoService")
@Transactional
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private CFPSService cfpsService;

	@Autowired
	private NormalizacaoService normalizacaoService;
	
	@Autowired
	private ProjetoDao projetoDao;

	public Projeto findById(Long id) {
		return projetoDao.findOne(id);
	}

	public Projeto findByName(String name) {
		return projetoDao.findByNome(name);
	}

	public void saveProjeto(Projeto projeto) {
		
		Cliente cliente = projeto.getCliente();
		
		CFPS cfps = cfpsService.findByCNPJ(cliente.getCnpj());
		if(cfps==null) {
			cfps = new CFPS();
			cfps.setCnpj(cliente.getCnpj());
			cfps.setContador(TipoContadorEnum.CLIENTE);
			cfps.setEmail(cliente.getEmail());
			cfps.setNome(cliente.getNome());
			cfpsService.saveCFPS(cfps);
			
		}
		if (!projeto.getCfpss().contains(cfps))
			projeto.getCfpss().add(cfps);
		
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

	@Override
	public Projeto calcularIA(Projeto projeto) {

		Projeto normalizar = normalizacaoService.normalizar(projeto);
		
		saveProjeto(normalizar);
		
		return normalizar;
	}

}