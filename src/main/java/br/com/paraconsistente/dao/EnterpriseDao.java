package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.Enterprise;

@Repository
public interface EnterpriseDao extends JpaRepository<Enterprise, Long> {

    Enterprise findByName(String name);

}