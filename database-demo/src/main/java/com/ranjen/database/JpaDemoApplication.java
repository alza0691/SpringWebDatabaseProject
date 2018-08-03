package com.ranjen.database;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.ranjen.database.jpa.entity.Person2;
import com.ranjen.database.jpa.repository.PersonJpaRepository;



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
//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 1 -> {}", repository.findById(1));
		
		//not assign id as hibernate will ignore the id.
		logger.info("Inserting -> {}", 
				repository.insert(new Person2("Mama", "Berlin", new Date())));
		
		//updating to do
		logger.info("Updating for id 1-> {}", 
				repository.updateLocation(1,"Mama","Tanjong Tokong"));
		
		//as it is void method , wil not return anything
		repository.deleteById(6);
		
		logger.info("All users -> {}", repository.findAll());
	
	}
}
