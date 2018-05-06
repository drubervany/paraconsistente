package br.com.paraconsistente.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.model.Funcao;
import br.com.paraconsistente.model.Projeto;

@Repository
public interface FuncaoDao extends JpaRepository<Funcao, Long> {

	Funcao findByNome(String tipoFuncao);

	List<Funcao> findByProjetoAndCfps(Projeto projeto, CFPS cfps);

}