package com.claim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.User;
import com.claim.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/submitUserDetails",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	public void sumbitStudentDetails(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(value="/findById",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> findStudent( String email) {
		
		return new ResponseEntity<> (userRepository.findById(email).get(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/login",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody 
	public ResponseEntity<User> login(@RequestBody User user) {
		
			
		
		 Optional<User> temp = userRepository.findByEmail(user.getEmail());
		 
		 System.out.println("Hello world");
		 if(!temp.isPresent()) {
				return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
		 }
		 
		 
		 
		if(temp.get().getPassword().equals(user.getPassword())) {
			return new ResponseEntity<> (temp.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
		}
		
		}

	
	
	@RequestMapping(value="/list",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> findStudent() {
		return new ResponseEntity<> (userRepository.findAll(),HttpStatus.OK);
	}
	
}
