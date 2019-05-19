package com.claim.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.claim.entity.Preference;
import com.claim.entity.User;
import com.claim.repository.PreferenceRepository;
import com.claim.repository.UserRepository;
import com.claim.restTemp.Item;
import com.claim.restTemp.ItemRequest;
import com.claim.restTemp.Options;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
	private UserRepository userRepository;

    @Autowired
	private PreferenceRepository prefRepository;
    
    
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
    	RestTemplate restTemplate = new RestTemplate();
    	
    	List<User> users = userRepository.findAll();
    	List<Preference> prefs = prefRepository.findAll();
		
		  for(User user: users) {
			  for(Preference pref : prefs) {
				  if(pref.getUser().getUserId() == user.getUserId()) {
					  log.info(user.getUsername() + " " + pref.getSearch());
					  ItemRequest itemRequest = new ItemRequest();
					  
					  itemRequest.setSearch(pref.getSearch());
					  
					  Options option = new Options();
					  option.setCategory(pref.getCategory());
					  option.setCity(pref.getBaseHost());
					  option.setHasImage(pref.isHasPic());
					  option.setMaxPrice(pref.getMaxPrice());
					  option.setMinPrice(pref.getMinPrice());
					  
					  itemRequest.setOptions(option);
					  
					 Item[] response = restTemplate.postForObject("http://localhost:3000/prefSearchPrice", itemRequest, Item[].class );
					  
					 for(int i =0 ; i < response.length; i++) {
						 log.info("PID: " + response[i].getPid() + " Date: " + response[i].getDate());
					 }
					  
				  }
				  
		    		
		    	}
		 }
		 
    	
    	
    	
    	
		/*
		 * RestTemplate restTemplate = new RestTemplate();
		 */    	
    	
		/*
		 * List<User> users = userRepository.findAll();
		 * 
		 * 
		 * for(User user : users) { for(Preference pref : user.getPreference()) {
		 * log.info(pref.getCity()); } }
		 */
    	
    	
    	
    	//restTemplate.postForEntity(url, request, responseType)
    	
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}