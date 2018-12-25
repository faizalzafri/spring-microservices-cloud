package com.faizal.services.springbootwebjpamongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.faizal.services.springbootwebjpamongo.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	public List<Person> findByLastName(String lastName);

	public List<Person> findByAgeGreaterThan(int age);

}
