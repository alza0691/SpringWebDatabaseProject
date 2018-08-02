package com.ranjen.database.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ranjen.database.springdatajpa.entity.Person;

@Repository
public interface PersonSpringJpaDataRepository 
				extends JpaRepository<Person, Integer>{
	//For Person the entity i will manage followed by primary key which is Integer
}