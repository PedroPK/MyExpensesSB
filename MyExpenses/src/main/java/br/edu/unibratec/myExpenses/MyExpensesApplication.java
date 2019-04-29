package br.edu.unibratec.myExpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.edu.unibratec.myExpenses.model.entities"})
public class MyExpensesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyExpensesApplication.class, args);
	}

}
