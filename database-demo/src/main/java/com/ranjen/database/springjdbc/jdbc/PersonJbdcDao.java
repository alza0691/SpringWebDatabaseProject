package com.ranjen.database.springjdbc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.ranjen.database.springjdbc.entity.Person;

@Repository
public class PersonJbdcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//how if the column name is different. Then we can configure our custom row mapper
	class PersonRowMapper implements RowMapper<Person>{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	public List<Person> findAllUsingCustomMapper() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public List<Person> findAll() {
		//to map the query result to the person object
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper(Person.class));
	}

	
	//method to find specific person by Id. Use queryForObject instead of query since
	//it is specific to one record
	public Person findById(int id) {
		return jdbcTemplate.queryForObject
				("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	//now try to delete the record based on id. Whenever wanted to use update or delete
	//query use the update method of the jdbctemplate.
	public int deleteById(int id) {
		//this will return int value , which is how many row affected with the update
		
		//for single parameter
/*		return jdbcTemplate.update
				("delete from person where id=?", new Object[] { id });*/
		
		//for multiple parameter
		return jdbcTemplate.update
				("delete from person where id=? or name=?", new Object[] { id , "Ranga" });
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) " 				+ "values(?,  ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
				new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
			return jdbcTemplate.update("update person " + " set name = ?, location = ?, 			birth_date = ? " + " where id = ?",
			new Object[] { person.getName(), person.getLocation(), new 			Timestamp(person.getBirthDate().getTime()),person.getId() });
	}
	
}
