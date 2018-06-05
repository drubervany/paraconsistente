package br.com.paraconsistente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class ApplicationController.
 * @author luiz.lima
 * Caminho inicial para as chamadas rest
 */
@Controller
public class ApplicationController {

	/**
	 * Home.
	 *
	 * @param modal the modal
	 * @return the string
	 */
	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title","CRUD Operation");
		return "index";
	}

	/**
	 * Partial handler.
	 *
	 * @param page the page
	 * @return the string
	 */
	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") String page) {
		return page;
	}

}