package com.example.demo2.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Person")
public class Person {

	  @Id
	  @Column(name = "id")
	private UUID id;
	  
	  @Column(name = "name")
	private String name;

	public Person() {
		super();
	}

	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
