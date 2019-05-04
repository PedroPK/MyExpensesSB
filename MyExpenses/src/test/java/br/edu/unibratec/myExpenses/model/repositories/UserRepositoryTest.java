package br.edu.unibratec.myExpenses.model.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.unibratec.myExpenses.model.entities.Address;
import br.edu.unibratec.myExpenses.model.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepositoryPagingSort aDao;
	
	/*
	 * @Before public void instancializarDAO() { this.aDao = new EnderecoDAO(); }
	 */
	
	@Test
	public void testarAtribuirDadosEndereco() {
		// Arrange		&&		Act
		Address address = new Address();
		address.setZipCode("51.234-56");
		address.setNumber((short) 123);
		address.setStreetAvenue("Av. Dantas Barreto");
		
		User user = new User ();
		user.setName("Not a homeless user");
		user.setEmail("user@home.com");
		user.setPassword("This is my Secret Password.");
		user.setaAddress(address);
	}
	
	@Test
	public void testSaveAddress() {
		/*
		 *  Arrange
		 */
		Address address = new Address();
		address.setZipCode("51.234-56");
		address.setNumber((short) 123);
		address.setStreetAvenue("Av. Dantas Barreto");
		
		User user = new User ();
		user.setName("Not a homeless user");
		user.setEmail("user@home.com");
		user.setPassword("This is my Secret Password.");
		user.setaAddress(address);
		
		// Act
		aDao.save(user);
		
		Optional<User> consultado = 
			aDao.findById((Long) user.getPrimaryKey());
		
		/*
		 *  Assert
		 */
		
		// Assert if the Find resultSet is not Null
		assertNotNull(consultado);
		
		// Assert if the Optional object contains a User object
		assertTrue(consultado.isPresent());
		
		// Compares if the consultado User is not the same object in memory
		assertNotSame(user,		consultado.get());
		
		// Compares if the consultado User is equivalent in content with the saved User
		assertEquals(user,		consultado.get());
	}
	
}