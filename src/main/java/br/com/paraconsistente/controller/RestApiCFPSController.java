package br.com.paraconsistente.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import br.com.paraconsistente.enuns.TipoContadorEnum;
import br.com.paraconsistente.model.CFPS;
import br.com.paraconsistente.service.CFPSService;
import br.com.paraconsistente.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiCFPSController {

	public static Logger logger = LoggerFactory.getLogger(RestApiCFPSController.class);

	@Autowired
	CFPSService cfpsService;

	// -------------------Retrieve All
	// CFPSs---------------------------------------------

	@RequestMapping(value = "/cfps/", method = RequestMethod.GET)
	public ResponseEntity<List<CFPS>> listAllCFPSs() {
		List<CFPS> cfps = cfpsService.findAllCFPSs().stream()
				.filter(s -> TipoContadorEnum.FORNECEDOR.equals(s.getContador())).collect(Collectors.toList());
		if (cfps.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<CFPS>>(cfps, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/cfps/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCFPS(@PathVariable("id") long id) {
		logger.info("Fetching CFPS with id {}", id);
		CFPS cfps = cfpsService.findById(id);
		if (cfps == null) {
			logger.error("CFPS with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("CFPS with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CFPS>(cfps, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cfps/cpf/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> getCPF(@PathVariable("cpf") String cpf) {
		logger.info("Fetching CFPS with cpf {}", cpf);
		CFPS cfps = cfpsService.findByCPF(cpf);
		if (cfps == null) {
			logger.error("CFPS with id {} not found.", cpf);
			return new ResponseEntity<>(new CustomErrorType("CFPS with id " + cpf + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CFPS>(cfps, HttpStatus.OK);
	}

	// -------------------Create a
	// CFPS-------------------------------------------

	@RequestMapping(value = "/cfps/", method = RequestMethod.POST)
	public ResponseEntity<?> createCFPS(@RequestBody CFPS cfps, UriComponentsBuilder ucBuilder) {
		logger.info("Creating CFPS : {}", cfps);

		if (cfpsService.isCFPSExist(cfps)) {
			logger.error("Unable to create. A CFPS with name {} already exist", cfps.getNome());
			return new ResponseEntity<>(
					new CustomErrorType("Unable to create. A CFPS with name " + cfps.getNome() + " already exist."),
					HttpStatus.CONFLICT);
		}
		cfpsService.saveCFPS(cfps);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/cfps/{id}").buildAndExpand(cfps.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a CFPS
	// ------------------------------------------------

	@RequestMapping(value = "/cfps/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCFPS(@PathVariable("id") long id, @RequestBody CFPS cfps) {
		logger.info("Updating CFPS with id {}", id);

		CFPS currentCFPS = cfpsService.findById(id);

		if (currentCFPS == null) {
			logger.error("Unable to update. CFPS with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. CFPS with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCFPS.setNome(cfps.getNome());

		cfpsService.updateCFPS(currentCFPS);
		return new ResponseEntity<CFPS>(currentCFPS, HttpStatus.OK);
	}

	// ------------------- Delete a
	// CFPS-----------------------------------------

	@RequestMapping(value = "/cfps/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCFPS(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting CFPS with id {}", id);

		CFPS cfps = cfpsService.findById(id);
		if (cfps == null) {
			logger.error("Unable to delete. CFPS with id {} not found.", id);
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. CFPS with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		cfpsService.deleteCFPSById(id);
		return new ResponseEntity<CFPS>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All CFPSs-----------------------------

	@RequestMapping(value = "/cfps/", method = RequestMethod.DELETE)
	public ResponseEntity<CFPS> deleteAllCFPSs() {
		logger.info("Deleting All CFPSs");

		cfpsService.deleteAllCFPSs();
		return new ResponseEntity<CFPS>(HttpStatus.NO_CONTENT);
	}

}