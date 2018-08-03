package com.ranjen.database;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ranjen.database.springdatajpa.entity.Person;
import com.ranjen.database.springdatajpa.repository.PersonSpringJpaDataRepository;

//test comment

/*
IMPORTANT : 
* Make sure @SpringBootApplication is commented in either 
JpaDemoApplication.java for JPA or SpringJpaDataDemoApplication for JPA 
or SpringJdbcDemoApplication.java for JDBC
* Make sure the create table statement is not commented , as we need to manually
create it for jdbc. For JPA , if it use memory database the schema will automatically 
created by JPA and not needed.

Please ensure maven project update, refresh and build again for each time you changes between
them.
*/

@SpringBootApplication
public class SpringJpaDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringJpaDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 1 -> {}", repository.findById(1));
		
		//In springdata there is not merge method as in the normal jpa, 
		//so for insert and update we use save method, rest all same
		logger.info("Inserting -> {}", 
				repository.save(new Person("Kusu", "Paris", new Date())));
		
		//updating to do
		//To update name as "Kaala" and location as "Dharavi" for id 1
		Optional<Person> person = repository.findById(1);
		Person personEntity = person.get();
		personEntity.setName("Kaala");
		personEntity.setLocation("Dharavi");
		logger.info("Updating for id 1-> {}", 
				repository.save(personEntity));
		
		//need to change each time based on the id deleted
		repository.deleteById(4);

		logger.info("All users -> {}", repository.findAll());
	}
}
