package br.com.paraconsistente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paraconsistente.model.CFPS;

/**
 * The Interface CFPSDao.
 */
@Repository
public interface CFPSDao extends JpaRepository<CFPS, Long> {

	/**
	 * Find by cpf.
	 *
	 * @param cpf the cpf
	 * @return the cfps
	 */
	CFPS findByCpf(String cpf);

	/**
	 * Find by cnpj.
	 *
	 * @param cnpj the cnpj
	 * @return the cfps
	 */
	CFPS findByCnpj(String cnpj);

}