package com.example.demo2.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.Person;
import com.example.demo2.sevice.PersonService;

@RestController
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping("/api/person")
	public int addPerson(@RequestBody Person p) {
		 personService.addPerson(p);
		 System.out.println(p.getName());
		 return 1;
	}

	@GetMapping("/getall")
	public List<Person> getAllPeople(){
		return personService.getAllPeople();
	}
	
	
	@GetMapping("/search/{id}")
	public Person getPersonByid(@PathVariable(value = "id") UUID id) {
		return personService.serachPeopleByID(id).orElse(null);
	}
	
	@DeleteMapping("/delete/{id}")
	public int deletePersonByid(@PathVariable("id") UUID id) {
	
	return personService.deletePersonById(id);	
	}
	
	@PutMapping("/update/{id}")
	public int updatePerson(@PathVariable("id") UUID id,@RequestBody Person p) {
	
		return personService.updatePerson(id, p);
	}
	
}

