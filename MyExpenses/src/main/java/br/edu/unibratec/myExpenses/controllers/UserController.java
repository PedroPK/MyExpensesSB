package br.edu.unibratec.myExpenses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unibratec.myExpenses.model.entities.User;
import br.edu.unibratec.myExpenses.model.repositories.UserRepositoryPagingSort;
import br.edu.unibratec.myExpenses.utils.UtilDateTime;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepositoryPagingSort	aRepository;
	
	@RequestMapping(
		value	= "/find/{name}",
		method	= RequestMethod.GET
	)
	public ModelAndView findByName(@PathVariable("name") String pName) {
		ModelAndView mav = new ModelAndView("userList");
		
		mav.addObject( "users", aRepository.findByName(pName));
		
		return mav;
	}
	
	/**
	 * URL to access this method
	 *  - http://localhost:9000/users/initialLoad
	 *  
	 * @return
	 */
	@RequestMapping("/initialLoad")
	public String inicialLoadUser() {
		User user = new User("Johnny", "johnny@is.com", "Planet of Apes");
		
		this.aRepository.save(user);
		
		return "The Default User was Saved in the Database." + 
					"<br>" + 
					UtilDateTime.getDataHoraHojeAgora();
	}
	
	/**
	 * URL to access this method
	 *  - http://localhost:9000/users/selectInitialLoadedUser
	 *  
	 * @return
	 */
	@RequestMapping("/selectInitialLoadedUser")
	public String selectInitialLoadedUser() {
		List<User> usersList = this.aRepository.findByName("John");
		
		String answer = ""; 
		if ( usersList == null || usersList.isEmpty() ) {
			answer = "There is no User saved at Database.";
		} else {
			for (User user: usersList) {
				answer = user.toString() + "\n<br>\n";
			}
		}
		
		return answer + 
				"<br>" + 
				UtilDateTime.getDataHoraHojeAgora();
	}
	
}