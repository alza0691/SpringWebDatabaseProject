package com.ranjen.database.jpa.entity;

//Now lets try using JPA instead of JDBC. JPA is interface and Hibernate is the ORM
//tool that implements JPA.
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



//normally the table name match with the name of the class so below is not needed
//unless the table name is different , put this before the class name
//@Table(name="person")

@Entity
@NamedQuery(name="find_all_persons", query="select p from Person p") 
//NamedQuery is for JPQL used in findAll method. Take note the Person in the query is
//referring to the entity Class name not Table name from database.
public class Person {
	
	@Id //indicate that this is primary key
	@GeneratedValue //let hibernate take control of generate id automatically 
	private int id;
	
	//same the column , since it match don't have to mentioned as below.
	//@Column(name="name")
	private String name;
	private String location;
	private Date birthDate;

	//always need to have no argument constructor
	public Person() {
	}

	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("\nPerson [id=%s, name=%s, location=%s, birthDate=%s]", id, name, location, birthDate);
	}

	
	
}
