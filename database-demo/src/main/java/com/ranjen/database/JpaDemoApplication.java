package com.ranjen.database;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ranjen.database.jpa.entity.Person;
import com.ranjen.database.jpa.repository.PersonJpaRepository;



/*
IMPORTANT : 
* Make sure @SpringBootApplication is commented in either 
JpaDemoApplication.java for JPA or SpringJdbcDemoApplication.java for JDBC
* Make sure the create table statement is not commented , as we need to manually
create it for jdbc. For JPA , if it use memory database the schema will automatically 
created by JPA and not needed.
*/
@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		//not assign id as hibernate will ignore the id.
		logger.info("Inserting -> {}", 
				repository.insert(new Person("Tara", "Berlin", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.update(new Person(10003, "Babu", "Malaysia", new Date())));
		//as it is void method , wil not return anything
		repository.deleteById(10002);
		
		logger.info("All users -> {}", repository.findAll());
	
	}
}
