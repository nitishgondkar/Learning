package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	//GET /users
	//retrieveAllUsers
	//http://localhost:8080/users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//retrieveUser(int id)
	//URL : http://localhost:8080/users/1
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+ id);
		}

		//HATEOAS
		//"all-users", SERVER-PATH + "/users"
		//retrieveAllUsers


 		return user;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+ id);
		}
	}
	
	//CREATED
	//input - Details of User
	//output - CREATED & Return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		//CREATED
		// /user/{id}   savedUser.getId()
	 	URI location =  ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}


}
