package br.com.paraconsistente.service;

import java.util.List;

import br.com.paraconsistente.enuns.TipoFuncaoEnum;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Medicao;
import br.com.paraconsistente.model.Projeto;

public interface MedicaoService {

	Medicao findById(Long id);

	Medicao findByName(TipoFuncaoEnum name);

	void save(Medicao medicao);

	void update(Medicao medicao);

	void delete(Long id);

	boolean isExist(Medicao medicao);

	List<Medicao> findAll();

	List<Medicao> findByCfps(CFPS cfps);

	List<Medicao> findByProjeto(Projeto projeto);

	List<Medicao> findByProjetoAndCfps(Projeto projeto, CFPS cfps);

	void finalizar(Projeto projeto, CFPS cfps);
}