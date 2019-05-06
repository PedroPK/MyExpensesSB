package br.edu.unibratec.myExpenses.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unibratec.myExpenses.utils.UtilDateTime;

@RestController
@RequestMapping("/")
public class MainController {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to inicial page of My Expenses App" + "<br>" + UtilDateTime.getDataHoraHojeAgora();
	}
	
	@GetMapping("/layout")
	public ModelAndView layout() {
		ModelAndView mv = new ModelAndView("layout");
		
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
}
