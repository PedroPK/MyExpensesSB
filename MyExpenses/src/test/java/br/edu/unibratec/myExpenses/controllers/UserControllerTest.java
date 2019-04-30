package br.edu.unibratec.myExpenses.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.unibratec.myExpenses.model.entities.User;
import br.edu.unibratec.myExpenses.model.repositories.UserRepositoryPagingSort;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private UserRepositoryPagingSort	aRepository;
	
	@Test
	public void insertUser() {
		// Arrange
		String name = "My name is not Johnny";
		User user = new User(name, "not@johnny.com", "12dot34");
		
		// Act
		aRepository.save(user);
		List<User> insertedUsersList = (List<User>) aRepository.findByName(name);
		
		// Assert
		assertNotNull(insertedUsersList);
		assertEquals(1,					insertedUsersList.size());
		
		User insertedUser = insertedUsersList.get(0);
		assertNotNull(insertedUser);
		assertNotSame(user,					insertedUser);
		assertEquals(user.getName(),		insertedUser.getName());
		assertEquals(user.getEmail(),		insertedUser.getEmail());
		assertEquals(user.getPassword(),	insertedUser.getPassword());
	}
	
}