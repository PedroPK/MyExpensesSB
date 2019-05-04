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
import br.edu.unibratec.myExpenses.model.entities.AddressPK;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository aDao;
	
	/*
	 * @Before public void instancializarDAO() { this.aDao = new EnderecoDAO(); }
	 */
	
	@Test
	public void testarAtribuirDadosEndereco() {
		// Arrange		&&		Act
		Address endereco = new Address();
		endereco.setZipCode("51.234-56");
		endereco.setNumber((short) 123);
		endereco.setStreetAvenue("Av. Dantas Barreto");
	}
	
	@Test
	public void testSaveAddress() {
		// Arrange
		Address endereco = new Address();
		endereco.setZipCode("51.234-56");
		endereco.setNumber((short) 123);
		endereco.setStreetAvenue("Av. Dantas Barreto");
		
		// Act
		aDao.save(endereco);
		
		Optional<Address> consultado = 
			aDao.findById((AddressPK) endereco.getPrimaryKey());
		
		/*
		 *  Assert
		 */
		
		// Assert if the Find resultSet is not Null
		assertNotNull(consultado);
		
		// Assert if the Optional object contains a Address object
		assertTrue(consultado.isPresent());
		
		// Compares if the consultado Address is not the same object in memory
		assertNotSame(endereco,		consultado.get());
		
		// Compares if the consultado Address is equivalent in content with the Saved
		assertEquals(endereco,		consultado.get());
	}
	
}