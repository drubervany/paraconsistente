package br.com.paraconsistente.service.impl;

import java.util.List;

import br.com.paraconsistente.dao.ClienteDao;
import br.com.paraconsistente.model.Cliente;
import br.com.paraconsistente.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	public Cliente findById(Long id) {
		return clienteDao.findOne(id);
	}

	public Cliente findByCnpj(String cnpj) {
		return clienteDao.findByCnpj(cnpj);
	}

	public void saveCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	public void updateCliente(Cliente cliente) {
		saveCliente(cliente);
	}

	public void deleteClienteById(Long id) {
		clienteDao.delete(id);
	}

	public void deleteAllClientes() {
		clienteDao.deleteAll();
	}

	public List<Cliente> findAllClientes() {
		return clienteDao.findAll();
	}

	public boolean isClienteExist(Cliente cliente) {
		return findByCnpj(cliente.getCnpj()) != null;
	}

}