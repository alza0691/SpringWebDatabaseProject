package com.ranjen.database;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ranjen.database.springdatajpa.entity.Person;
import com.ranjen.database.springdatajpa.repository.PersonSpringJpaDataRepository;

/*
IMPORTANT : 
* Make sure @SpringBootApplication is commented in either 
JpaDemoApplication.java for JPA or SpringJpaDataDemoApplication for JPA 
or SpringJdbcDemoApplication.java for JDBC
* Make sure the create table statement is not commented , as we need to manually
create it for jdbc. For JPA , if it use memory database the schema will automatically 
created by JPA and not needed.
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
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		//In springdata there is not merge method as in the normal jpa, 
		//so for insert and update we use save method, rest all same
		logger.info("Inserting -> {}", 
				repository.save(new Person("Tara", "Berlin", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.save(new Person(10003, "Pieter", "Utrecht", new Date())));
		
		repository.deleteById(10002);

		logger.info("All users -> {}", repository.findAll());
	}
}
