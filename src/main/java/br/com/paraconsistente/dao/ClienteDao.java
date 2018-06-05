package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.Cliente;

/**
 * The Interface ClienteDao.
 */
@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

	/**
	 * Find by cnpj.
	 *
	 * @param cnpj the cnpj
	 * @return the cliente
	 */
	Cliente findByCnpj(String cnpj);

}