package com.example.demo2.sevice;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo2.dao.PersonDao;
import com.example.demo2.model.Person;

@Service
public class PersonService {

	private final PersonDao personDoa;

	@Autowired
	public PersonService(@Qualifier("postgres") PersonDao personDoa) {
		super();
		this.personDoa = personDoa;
	}

	public int addPerson(Person p) {
		System.out.println(p.getName());
		return personDoa.insertPerson(p);

	}

	public List<Person> getAllPeople() {
		return personDoa.getAllPerson();

	}

	public Optional<Person> serachPeopleByID(UUID id) {
		return personDoa.searchPersonById(id);

	}

	public int deletePersonById(UUID id) {
		return personDoa.deletePersonById(id);
	}
	
	public int updatePerson(UUID id,Person p)
	{
		return personDoa.updatePersonById(id, p);
		
	}
}
