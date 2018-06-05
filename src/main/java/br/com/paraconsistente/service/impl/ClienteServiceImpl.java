package br.com.paraconsistente.service.impl;

import java.util.List;

import br.com.paraconsistente.dao.ClienteDao;
import br.com.paraconsistente.model.Cliente;
import br.com.paraconsistente.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class ClienteServiceImpl.
 */
@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	/** The cliente dao. */
	@Autowired
	private ClienteDao clienteDao;

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#findById(java.lang.Long)
	 */
	public Cliente findById(Long id) {
		return clienteDao.findOne(id);
	}

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#findByCnpj(java.lang.String)
	 */
	public Cliente findByCnpj(String cnpj) {
		return clienteDao.findByCnpj(cnpj);
	}

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#saveCliente(br.com.paraconsistente.model.Cliente)
	 */
	public void saveCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#updateCliente(br.com.paraconsistente.model.Cliente)
	 */
	public void updateCliente(Cliente cliente) {
		saveCliente(cliente);
	}

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#deleteClienteById(java.lang.Long)
	 */
	public void deleteClienteById(Long id) {
		clienteDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#deleteAllClientes()
	 */
	public void deleteAllClientes() {
		clienteDao.deleteAll();
	}

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#findAllClientes()
	 */
	public List<Cliente> findAllClientes() {
		return clienteDao.findAll();
	}

	/* (non-Javadoc)
	 * @see br.com.paraconsistente.service.ClienteService#isClienteExist(br.com.paraconsistente.model.Cliente)
	 */
	public boolean isClienteExist(Cliente cliente) {
		return findByCnpj(cliente.getCnpj()) != null;
	}

}