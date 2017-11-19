package br.com.paraconsistente.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paraconsistente.model.Cliente;
import br.com.paraconsistente.service.ClienteService;
import br.com.paraconsistente.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiClienteController {

	public static Logger logger = LoggerFactory.getLogger(RestApiClienteController.class);

	@Autowired
	ClienteService clienteService;

	// -------------------Retrieve All
	// Clientes---------------------------------------------

	@RequestMapping(value = "/clientes/", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listAllClientes() {
		List<Cliente> clientes = clienteService.findAllClientes();
		if (clientes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Cliente------------------------------------------

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCliente(@PathVariable("id") long id) {
		logger.info("Fetching Cliente with id {}", id);
		Cliente cliente = clienteService.findById(id);
		if (cliente == null) {
			logger.error("Cliente with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Cliente with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/clientes/cnpj/{cnpj}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getCliente(@PathVariable("cnpj") String cnpj) {
		logger.info("Fetching Cliente with id {}", cnpj);
		Cliente cliente = clienteService.findByCnpj(cnpj);
		if (cliente == null) {
			logger.error("Cliente with id {} not found.", cnpj);
			return new ResponseEntity(new CustomErrorType("Cliente with cnpj " + cnpj + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	// -------------------Create a
	// Cliente-------------------------------------------

	@RequestMapping(value = "/clientes/", method = RequestMethod.POST)
	public ResponseEntity<?> createCliente(@RequestBody Cliente cliente, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Cliente : {}", cliente);

		if (clienteService.isClienteExist(cliente)) {
			logger.error("Unable to create. A Cliente with name {} already exist", cliente.getNome());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Cliente with name " + cliente.getNome() + " already exist."),
					HttpStatus.CONFLICT);
		}
		clienteService.saveCliente(cliente);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Cliente
	// ------------------------------------------------

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		logger.info("Updating Cliente with id {}", id);

		Cliente currentCliente = clienteService.findById(id);

		if (currentCliente == null) {
			logger.error("Unable to update. Cliente with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Cliente with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCliente.setNome(cliente.getNome());

		clienteService.updateCliente(currentCliente);
		return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK);
	}

	// ------------------- Delete a
	// Cliente-----------------------------------------

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCliente(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Cliente with id {}", id);

		Cliente cliente = clienteService.findById(id);
		if (cliente == null) {
			logger.error("Unable to delete. Cliente with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Cliente with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		clienteService.deleteClienteById(id);
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Clientes-----------------------------

	@RequestMapping(value = "/clientes/", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> deleteAllClientes() {
		logger.info("Deleting All Clientes");

		clienteService.deleteAllClientes();
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}

}