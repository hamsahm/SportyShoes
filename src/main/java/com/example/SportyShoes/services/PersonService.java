package com.example.SportyShoes.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportyShoes.entity.Person;
import com.example.SportyShoes.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllUsers() {
		return personRepository.findAll();
	}

	public List<Person> getListOfRegisteredUsers() {
		return personRepository.findByIsRegistered(true);
	}

	public Optional<Person> getUserById(int id) {
		return personRepository.findById(id);
	}

	public Person login(String username, String password) {
		Person person = personRepository.findByUsernameAndPassword(username, password);
		System.out.println("User found : " + person);
		return person;
	}

	public boolean changePassword(String username, String newPassword) {
		Person person = personRepository.findByUsername(username);
		if (Objects.nonNull(person)) {
			personRepository.changePassword(newPassword, person.getId());
			System.out.println("User " + person.getUsername() + " has successfuly changed the password");
			return true;
		} else {
			System.out.println("Unable to change the password!");
			return false;
		}

	}

	public Person addUser(Person person) {
		return personRepository.save(person);
	}

}
