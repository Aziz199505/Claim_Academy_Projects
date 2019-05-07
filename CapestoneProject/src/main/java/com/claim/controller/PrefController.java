package com.claim.controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.Preference;
import com.claim.repository.UserRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
public class PrefController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value="/submitPrefDetails",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	public void sumbitPrefDetail(@RequestBody String json) {
		//Send Mail sendMail.sendMail(user.getEmail(), "Welcome", user.getUsername() + " thanks for registering!");
		//userRepository.save(user);
		//System.out.println(json);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		Preference pref = new Preference();
		try {
			
			pref = mapper.readValue(json,Preference.class);
			System.out.println(pref);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JSONObject jsonObj =new JSONObject(json);
		/*
		 * String name=jsonObj.getString(“name”);
		 * 
		 * int age=jsonObj.getInt(“age”);
		 */
		
	}
	

}
