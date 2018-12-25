package com.faizal.services.springbootweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonFactoryService {

	private List<com.faizal.services.springbootweb.model.Person> persons = new ArrayList<>();

	public List<com.faizal.services.springbootweb.model.Person> getPersons() {
		return persons;
	}
}
