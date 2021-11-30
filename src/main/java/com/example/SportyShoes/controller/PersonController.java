package com.example.SportyShoes.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SportyShoes.entity.Person;
import com.example.SportyShoes.exception.UserNotFoundException;
import com.example.SportyShoes.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/users")
	public List<Person> listUsers() {
		return personService.getAllUsers();
	}

	@GetMapping("/users/registeredUsers")
	public List<Person> listRegisteredUsers() {
		return personService.getListOfRegisteredUsers();
	}

	@PostMapping("/users")
	public Person addUsers(@RequestBody Person person) {
		return personService.addUser(person);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Optional<Person>> searchUser(@PathVariable("id") int id) {

		Optional<Person> person = personService.getUserById(id);

		if (!person.isEmpty()) {
			return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
		} else
			throw new UserNotFoundException(id);
	}

	@GetMapping("/login")
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		Person person = personService.login(username, password);
		if (Objects.nonNull(person)) {
			return "Welcome to the application!";
		} else {
			return "Please sign up to the application!";
		}
	}

	@PutMapping("/users/changePassword")
	public String changePassword(@RequestParam("username") String username,
			@RequestParam("newPassword") String newPassword) {

		boolean passwordChanged = personService.changePassword(username, newPassword);
		if (Objects.nonNull(passwordChanged)) {
			return "Password changed Successfully";
		} else {
			return "Something went wrong, Credentials mismatch!";
		}
	}

}
