package com.example.demo2.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.Person;


public interface PersonDataAccessPostgres  extends JpaRepository<Person, UUID> {

	

}
