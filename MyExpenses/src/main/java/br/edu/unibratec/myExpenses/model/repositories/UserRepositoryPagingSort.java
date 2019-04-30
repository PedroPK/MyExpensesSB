package br.edu.unibratec.myExpenses.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unibratec.myExpenses.model.entities.User;

@Repository			// Once it extends a Spring Data Repository Interface, this annotation is just didactic, informational and optional. 
public interface UserRepositoryPagingSort extends PagingAndSortingRepository<User, Long> {
	
	// Manually implemented methods
	
	/*
	 * The problem below its been caused by this @Query
	 * 
	 * org.springframework.beans.factory.UnsatisfiedDependencyException: 
	 * 		Error creating bean with name 'profileController' defined in URL [jar:file:/Users/pedropk/.m2/repository/org/springframework/data/spring-data-rest-webmvc/3.1.6.RELEASE/spring-data-rest-webmvc-3.1.6.RELEASE.jar!/org/springframework/data/rest/webmvc/ProfileController.class]: 
	 * 		Unsatisfied dependency expressed through constructor parameter 0; 
	 * 		nested exception is org.springframework.beans.factory.BeanCreationException: 
	 * 		Error creating bean with name 'repositoryRestConfiguration' defined in class path resource [org/springframework/data/rest/webmvc/config/RepositoryRestMvcConfiguration.class]: 
	 * 		Bean instantiation via factory method failed; 
	 * 		nested exception is org.springframework.beans.BeanInstantiationException: 
	 * 		Failed to instantiate [org.springframework.data.rest.core.config.RepositoryRestConfiguration]: 
	 * 		Factory method 'repositoryRestConfiguration' threw exception; 
	 * 		nested exception is org.springframework.beans.factory.BeanCreationException: 
	 * 		Error creating bean with name 'repositories' defined in class path resource [org/springframework/data/rest/webmvc/config/RepositoryRestMvcConfiguration.class]: 
	 * 		Bean instantiation via factory method failed; 
	 * 		nested exception is org.springframework.beans.BeanInstantiationException: 
	 * 		Failed to instantiate [org.springframework.data.repository.support.Repositories]: 
	 * 		Factory method 'repositories' threw exception; 
	 * 		nested exception is org.springframework.beans.factory.BeanCreationException: 
	 * 		Error creating bean with name 'userRepository': 
	 * 		Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: 
	 * 		Validation failed for query for method public abstract java.util.List br.edu.unibratec.myExpenses.model.repositories.UserRepository.findByName(java.lang.String)!
	 * 
	 * Problem solved.
	 * 		- The Attribute aName have to be used with its original Identifier, not by the respective Get Method Identifier
	 */
	@Query( "Select u From User u Where u.aName Like %:filter%")
	public List<User> findByName(@Param("filter") String pName );
	
}