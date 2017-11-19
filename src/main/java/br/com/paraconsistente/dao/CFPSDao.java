package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.CFPS;

@Repository
public interface CFPSDao extends JpaRepository<CFPS, Long> {

	CFPS findByNome(String nome);

}