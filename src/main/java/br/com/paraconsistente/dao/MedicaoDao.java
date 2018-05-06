package br.com.paraconsistente.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.enuns.TipoFuncaoEnum;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Medicao;
import br.com.paraconsistente.model.Projeto;

@Repository
public interface MedicaoDao extends JpaRepository<Medicao, Long> {

	Medicao findByTipo(TipoFuncaoEnum tipoFuncao);

	List<Medicao> findByCfps(CFPS cfps);
	
	List<Medicao> findByProjeto(Projeto projeto);

}