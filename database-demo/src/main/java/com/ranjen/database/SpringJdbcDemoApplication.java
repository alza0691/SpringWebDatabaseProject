package com.ranjen.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ranjen.database.springjdbc.entity.Person;
import com.ranjen.database.springjdbc.jdbc.PersonJbdcDao;

/*
IMPORTANT : 
* Make sure @SpringBootApplication is commented in either 
JpaDemoApplication.java for JPA or SpringJpaDataDemoApplication for JPA 
or SpringJdbcDemoApplication.java for JDBC
* Make sure the create table statement is not commented , as we need to manually
create it for jdbc. For JPA , if it use memory database the schema will automatically 
created by JPA and not needed.
*/

//using run methd from CommandLineRunner interface to execute the query when first time
//the application load.
//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJbdcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//will get the value and put inside {}
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Deleting 10002 -> No of Rows Deleted - {}", dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}", 
				dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("Update 10003 -> {}", 
				dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		logger.info("Using custom mapper-> {}",dao.findAllUsingCustomMapper());
	}
}
