package br.edu.unibratec.myExpenses.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@RequestMapping(
		value	= "/find/{name}",
		method	= RequestMethod.GET
	)
	public ModelAndView findByName(@PathVariable("name") String pName) {
		ModelAndView mav = new ModelAndView("userList");
		
		/*
		 * mav.addObject( "users", aRepository.findByName(pName));
		 */
		
		return mav;
	}
	
}