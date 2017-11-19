package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

	Cliente findByCnpj(String cnpj);

}