package br.com.paraconsistente.service;


import java.util.List;

import br.com.paraconsistente.model.Cliente;

public interface ClienteService {
	
	Cliente findById(Long id);

	Cliente findByCnpj(String cnpj);

	void saveCliente(Cliente cliente);

	void updateCliente(Cliente cliente);

	void deleteClienteById(Long id);

	void deleteAllClientes();

	List<Cliente> findAllClientes();

	boolean isClienteExist(Cliente Cliente);
}