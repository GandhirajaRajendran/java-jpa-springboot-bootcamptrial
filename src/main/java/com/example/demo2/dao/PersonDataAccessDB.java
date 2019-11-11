package com.example.demo2.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo2.model.Person;

@Repository("fake")
public class PersonDataAccessDB implements PersonDao {

	private static List<Person> Db = new ArrayList<Person>();

	@Override
	public int insertPerson(UUID id, Person p) {

		Db.add(new Person(id, p.getName()));
		return 1;
	}

	@Override
	public List<Person> getAllPerson() {

		return Db;
	}

	@Override
	public int deletePersonById(UUID id) {
	Optional<Person> personMaybe = searchPersonById(id);
	if(personMaybe.isPresent()) {
		Db.remove(personMaybe.get());
		return 1;
	}else
	{
		return 0;
	}
		

	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return searchPersonById(id).map(p -> {
			int index= Db.indexOf(p);
			if (index>=0) {
			Db.set(index,new  Person(id,person.getName()));
			return 1;
			}else
			{
			return 0;
			}
		}).orElse(0);
	
	}

	@Override
	public Optional<Person> searchPersonById(UUID id) {
		return Db.stream().filter(person -> person.getId().equals(id)).findFirst();

	}

}
