package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.Gerente;

@Repository
public interface GerenteDao extends JpaRepository<Gerente, Long> {

}