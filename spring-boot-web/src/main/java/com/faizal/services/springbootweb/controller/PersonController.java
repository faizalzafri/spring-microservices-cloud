package com.faizal.services.springbootweb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faizal.services.springbootweb.model.Person;
import com.faizal.services.springbootweb.service.PersonCounterService;
import com.faizal.services.springbootweb.service.PersonFactoryService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonFactoryService personFactoryService;

	@Autowired
	PersonCounterService counterService;

	@GetMapping
	public List<Person> findAll() {
		return personFactoryService.getPersons();
	}

	@GetMapping("/{id}")
	public Person findById(@RequestParam("id") Long id) {
		return personFactoryService.getPersons().stream().filter(it -> it.getId().equals(id)).findFirst().get();
	}

	@PostMapping
	public Person add(@RequestBody Person p) {
		p.setId((long) (personFactoryService.getPersons().size() + 1));
		personFactoryService.getPersons().add(p);
		counterService.countNewPersons();
		return p;
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam("id") Long id) {
		List<Person> p = personFactoryService.getPersons()
				.stream().filter(it -> it.getId().equals(id))
				.collect(Collectors.toList());
		personFactoryService.getPersons().removeAll(p);
		counterService.countDeletedPersons();
	}

	@PutMapping
	public void update(@RequestBody Person p) {
		Person person = personFactoryService.getPersons()
				.stream()
				.filter(it -> it.getId().equals(p.getId()))
				.findFirst()
				.get();
		personFactoryService.getPersons().set(
				personFactoryService.getPersons().indexOf(person), p);
	}

}
