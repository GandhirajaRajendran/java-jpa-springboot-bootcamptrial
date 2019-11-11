package com.example.demo2.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo2.model.Person;

public interface PersonDao{

	int insertPerson(UUID id, Person p);

	default int insertPerson(Person p) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, p);
	}

	List<Person> getAllPerson();
	
	int deletePersonById(UUID id);
	
	int updatePersonById(UUID id,Person p);
	
	Optional<Person> searchPersonById(UUID id);
}
