package com.ranjen.database.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ranjen.database.jpa.entity.Person;


//@Repository to manage the entity
//@Transactional when insert,delete,or update need to use transactional 
@Repository 
@Transactional 
public class PersonJpaRepository {
	
	//connect to the database
	//In Springjdbc we use JDBCTemplate. 
	//EntityManager manages the entity, all operations stored in and must go through 
	//EntityManager , it is interface to the @PersistenceContext
	@PersistenceContext
	EntityManager entityManager;
	
	//In JPA we use Java Persistence Query Language ( JPQL) instead of sql for query
	//give the query a name like find_all_persons as below
	//JPQL does not use table from database , it use entities.
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);//JPA
	}
	
	//to insert or update , we need to use merge method of the EntityManager
	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	//to remove the record by ID.
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
}
