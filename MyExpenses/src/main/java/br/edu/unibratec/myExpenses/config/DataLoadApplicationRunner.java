package br.edu.unibratec.myExpenses.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.unibratec.myExpenses.model.entities.User;
import br.edu.unibratec.myExpenses.model.repositories.UserRepositoryPagingSort;

@Configuration
public class DataLoadApplicationRunner implements ApplicationRunner {
	
	@Autowired
	private UserRepositoryPagingSort aRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user1 = new User("User 1 Name - ApplicationRunner", "user1@email.com", "user 1 password");
		User user2 = new User("User 2 Name - ApplicationRunner", "user2@email.com", "user 2 password");
		User user3 = new User("User 3 Name - ApplicationRunner", "user3@email.com", "user 3 password");
		
		this.aRepository.save(user1);
		this.aRepository.save(user2);
		this.aRepository.save(user3);
	}

}
