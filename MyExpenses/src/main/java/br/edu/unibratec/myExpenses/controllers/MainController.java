package br.edu.unibratec.myExpenses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unibratec.myExpenses.utils.UtilDateTime;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "Welcome to inicial page of My Expenses App" + "<br>" + UtilDateTime.getDataHoraHojeAgora();
	}
	
}
