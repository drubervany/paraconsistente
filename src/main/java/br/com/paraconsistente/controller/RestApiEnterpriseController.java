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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paraconsistente.model.Enterprise;
import br.com.paraconsistente.service.EnterpriseService;
import br.com.paraconsistente.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiEnterpriseController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiEnterpriseController.class);

	@Autowired
	EnterpriseService enterpriseService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Enterprises---------------------------------------------

	@RequestMapping(value = "/enterprise/", method = RequestMethod.GET)
	public ResponseEntity<List<Enterprise>> listAllEnterprises() {
		List<Enterprise> enterprises = enterpriseService.findAllEnterprises();
		if (enterprises.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Enterprise>>(enterprises, HttpStatus.OK);
	}

	// -------------------Retrieve Single Enterprise------------------------------------------

	@RequestMapping(value = "/enterprise/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEnterprise(@PathVariable("id") long id) {
		logger.info("Fetching Enterprise with id {}", id);
		Enterprise enterprise = enterpriseService.findById(id);
		if (enterprise == null) {
			logger.error("Enterprise with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Enterprise with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
	}

	// -------------------Create a Enterprise-------------------------------------------

	@RequestMapping(value = "/enterprise/", method = RequestMethod.POST)
	public ResponseEntity<?> createEnterprise(@RequestBody Enterprise enterprise, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Enterprise : {}", enterprise);

		if (enterpriseService.isEnterpriseExist(enterprise)) {
			logger.error("Unable to create. A Enterprise with name {} already exist", enterprise.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Enterprise with name " + 
			enterprise.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		enterpriseService.saveEnterprise(enterprise);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/enterprise/{id}").buildAndExpand(enterprise.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Enterprise ------------------------------------------------

	@RequestMapping(value = "/enterprise/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEnterprise(@PathVariable("id") long id, @RequestBody Enterprise enterprise) {
		logger.info("Updating Enterprise with id {}", id);

		Enterprise currentEnterprise = enterpriseService.findById(id);

		if (currentEnterprise == null) {
			logger.error("Unable to update. Enterprise with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Enterprise with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentEnterprise.setName(enterprise.getName());
		currentEnterprise.setSiren(enterprise.getSiren());
		currentEnterprise.setCapital(enterprise.getCapital());

		enterpriseService.updateEnterprise(currentEnterprise);
		return new ResponseEntity<Enterprise>(currentEnterprise, HttpStatus.OK);
	}

	// ------------------- Delete a Enterprise-----------------------------------------

	@RequestMapping(value = "/enterprise/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEnterprise(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Enterprise with id {}", id);

		Enterprise enterprise = enterpriseService.findById(id);
		if (enterprise == null) {
			logger.error("Unable to delete. Enterprise with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Enterprise with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		enterpriseService.deleteEnterpriseById(id);
		return new ResponseEntity<Enterprise>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Enterprises-----------------------------

	@RequestMapping(value = "/enterprise/", method = RequestMethod.DELETE)
	public ResponseEntity<Enterprise> deleteAllEnterprises() {
		logger.info("Deleting All Enterprises");

		enterpriseService.deleteAllEnterprises();
		return new ResponseEntity<Enterprise>(HttpStatus.NO_CONTENT);
	}

}