package com.claim.controller;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.prefs.Preferences;

import org.json.JSONObject;
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

import com.claim.entity.DateTimeFormat;
import com.claim.entity.Notify;
import com.claim.entity.Preference;
import com.claim.entity.User;
import com.claim.entity.Week;
import com.claim.entity.WeekTime;
import com.claim.repository.CraiglistItemRepository;
import com.claim.repository.PreferenceRepository;
import com.claim.repository.UserRepository;
import com.claim.repository.WeekTimeRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
public class PrefController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WeekTimeRepository weekTimeRepository;
	
	@Autowired
	private PreferenceRepository prefRepository;
	
	
	
	
	
	@RequestMapping(value="/deletePref",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	public void sumbitStudentDetails(@RequestBody String json) {
		//Send Mail sendMail.sendMail(user.getEmail(), "Welcome", user.getUsername() + " thanks for registering!");
		//userRepository.save(user);
		JSONObject jsonObj = new JSONObject(json);
		int userId = jsonObj.getInt("userId");
		int pId = jsonObj.getInt("prefId");
		
		User user  = userRepository.findByUserId(Long.valueOf(String.valueOf(userId))).get();
		
		long prefId = Long.valueOf(String.valueOf(pId));
		System.out.println(user.getFirstName());
		Set<Preference> prefs = new HashSet<Preference>();

		
	   
		/* craigItemRepository.deleteCraigItemByPrefId(String.valueOf(pId)); */
		
		for(Preference pref : user.getPreference()) {
			if(pref.getPrefId() != prefId) {
				/*
				 * System.out.println(pref.getCity() + " " + pref.getSearch() + " " +
				 * pref.getPrefId()); user.getPreference().remove(pref);
				 */
				System.out.println("Adding " + pref.getPrefId());
				prefs.add(pref);
			}
		}
		
		

		
		user.getPreference().clear();
		user.getPreference().addAll(prefs);
		
		
		
		userRepository.save(user);
		//System.out.println(json);
	}
	
	
	
	@RequestMapping(value="/fetchPrefs",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody 
	public ResponseEntity<Set<Preference>> login(@RequestBody User user) {
		
		 Optional<User> temp = userRepository.findByUserId(user.getUserId());
		 
		 //System.out.println("Hello world");
		 if(!temp.isPresent()) {
				return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
		 }

		User u = temp.get();
			
		
		Set<Preference> prefs = new HashSet<Preference>();
		
		
		for(Preference p : u.getPreference()) {
			p.setNotifyDetail(null);
			p.setUser(null);
			prefs.add(p);
		}
		
			
			
		return new ResponseEntity<> (prefs,HttpStatus.OK);
				
	}
		
	

	@RequestMapping(value = "/submitPrefDetails", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void sumbitPrefDetail(@RequestBody String json) {
		// Send Mail sendMail.sendMail(user.getEmail(), "Welcome", user.getUsername() +
		// " thanks for registering!");
		// userRepository.save(user);
		// System.out.println(json);

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		Preference pref = new Preference();
		try {

			pref = mapper.readValue(json, Preference.class);
			System.out.println(pref);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jsonObj = new JSONObject(json);
		Set<Notify> notifies = new HashSet();

		/*
		 * JSONObject name = jsonObj.getJSONObject("detailEmailOpt");
		 * System.out.println(name);
		 */

		int userId = jsonObj.getInt("userId");
		
		
		User user  = userRepository.findByUserId(Long.valueOf(String.valueOf(userId))).get();
		Set<Preference> prefs = new HashSet();

		
		
		System.out.println("User ID: " + userId);
		System.out.println("User Name: " + user.getFirstName());

		
		/*
		 * try { WeekTime weekTime =
		 * mapper.readValue(jsonObj.getJSONObject("detailEmailOpt").toString(),WeekTime.
		 * class);
		 */
			 
			 //jsonObj.getJSONObject("detailEmailOpt").get(key)
		
		String[] details = {"detailEmailOpt","detailTextOpt"};
		
		for(String detail : details) {
		
			String name = jsonObj.getJSONObject(detail).getString("name");
			System.out.println("Name: " + name);
			Notify notify = new Notify();
			notify.setName(name);
			Set<WeekTime> weekTimes = new HashSet();
	
			
			EnumSet.allOf(Week.class).forEach(w -> {
					 try {
						 //System.out.println(jsonObj.getJSONObject("detailEmailOpt").getJSONArray(w.toString()));
						 WeekTime weekTime = new WeekTime();
						 weekTime.setWeek(w);
						 Set<DateTimeFormat> allTimes = new HashSet();
	
						 for(Object o : jsonObj.getJSONObject(detail).getJSONArray(w.toString())) {
							 if(o instanceof JSONObject) {
								 DateTimeFormat dateTimeFormat = mapper.readValue(o.toString(),DateTimeFormat.class);
								 
								
								 //System.out.println(dateTimeFormat + "\t" + w.toString());
								 dateTimeFormat.setWeek(weekTime);
								 allTimes.add(dateTimeFormat);							
							 }
						 }
						 
						 weekTime.setDateTimeFormat(allTimes);
						 weekTime.setNotify(notify);
						 //weekTimeRepository.save
						 weekTimes.add(weekTime);
						 //System.out.println(weekTime);
						 
					 }catch(Exception e) {
						 System.out.println(e);
					 }
				 });
		 
			
			notify.setWeekTime(weekTimes);
			notify.setPreference(pref);
			notifies.add(notify);
		}
		
		pref.setNotifyDetail(notifies);
		pref.setUser(user);
		
		for(Preference p: user.getPreference()) {
			prefs.add(p);
		}
		prefs.add(pref);
		
		
		
		user.setPreference(prefs);
		
		
		
		userRepository.save(user);
		//System.out.println(pref.getNotifyDetail());
		
		
		//for(Notify n : pref.getNotifyDetail()) { System.out.println(n.getNotifyId()); }
		 
		
		 //System.out.println(weekTime);
		 
/*		} catch (JSONException | IOException e) { // TODO Auto-generated catch block
			e.printStackTrace(); 
		 }*/
		 

		/*
		 * String name=jsonObj.getString(“name”);
		 * 
		 * int age=jsonObj.getInt(“age”);
		 */

	}

}
