package com.example.demo2.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo2.model.Person;

@Repository("postgres")
public class PErsonDataAccessPostgresscl implements PersonDao {

	@Autowired
	private final PersonDataAccessPostgres pps;

	public PErsonDataAccessPostgresscl(PersonDataAccessPostgres pps) {
		super();
		this.pps = pps;
	}

	@Override
	public int insertPerson(UUID id, Person p) {

		pps.save(new Person(id,p.getName()));

		return 1;
	}

	@Override
	public List<Person> getAllPerson() {

		return pps.findAll();
	}

	@Override
	public int deletePersonById(UUID id) {

		pps.deleteById(id);
		return 1;

	}

	@Override
	public int updatePersonById(UUID id, Person p) {
		Person person = pps.findById(id).orElse(null);
		person.setId(id);
		person.setName(p.getName());
		pps.save(person);
		return 1;
	}

	@Override
	public Optional<Person> searchPersonById(UUID id) {

		return pps.findById(id);

	}
}
