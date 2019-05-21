package com.claim.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.claim.controller.SendMail;
import com.claim.controller.TestTwilio;
import com.claim.entity.CraiglistItem;
import com.claim.entity.Preference;
import com.claim.entity.User;
import com.claim.repository.CraiglistItemRepository;
import com.claim.repository.PreferenceRepository;
import com.claim.repository.UserRepository;
import com.claim.restTemp.Item;
import com.claim.restTemp.ItemDetail;
import com.claim.restTemp.ItemRequest;
import com.claim.restTemp.Options;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    SimpleDateFormat dateForamter =new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
    
	TestTwilio tt = new TestTwilio();

    
    @Autowired
	private UserRepository userRepository;

    @Autowired
	private PreferenceRepository prefRepository;
    
    @Autowired
   	private CraiglistItemRepository craigItemRepository;
    
    @Autowired
	SendMail sendMail;
    
    @Scheduled(fixedRate = 30000)
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
					 List<CraiglistItem> newItems = new ArrayList<>();
					 for(int i =0 ; i < response.length; i++) {
						 log.info("PID: " + response[i].getPid() + " Date: " + response[i].getDate());
						 Optional<CraiglistItem> tempCraigItem =  craigItemRepository.findByPid(response[i].getPid());
						 
						 if(!tempCraigItem.isPresent()) {
							 
							 
							 
							 CraiglistItem craigItem = new CraiglistItem();
							 craigItem.setPrefId(pref.getPrefId());
							 craigItem.setPid(response[i].getPid());
							 craigItem.setPrice(response[i].getPrice());
							 try {
							  craigItem.setDate(dateForamter.parse(response[i].getDate()));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							 
							 
							 newItems.add(craigItem);
							 craigItemRepository.save(craigItem) ;
							 
						 }
						 
						 
						 
						 
					 }
					 
					 
					 if(newItems.size() > 0) {
						 String tempBody = "";
						 ItemDetail[] responseDetail = restTemplate.postForObject("http://localhost:3000/prefSearch", itemRequest, ItemDetail[].class );
						 for(CraiglistItem ci : newItems) {
							 for(int j = 0; j < responseDetail.length; j++) {
								 
								 if(ci.getPid().equals(responseDetail[j].getPid())) {
									 log.info("New Item has been found");
									 log.info("Title " + responseDetail[j].getTitle());
									 log.info("Price " + ci.getPrice());
									 log.info("Url " + responseDetail[j].getUrl());
									 
									 tempBody += "New Item has been found\n";
									 tempBody += "Title: " + responseDetail[j].getTitle() + "\n";
									 tempBody += "Price: " + ci.getPrice()  + "\n" ;
									 tempBody += "Url: " + responseDetail[j].getUrl() + "\n";
									 tempBody += "Search for: " + pref.getSearch() + " in " + pref.getState() + "\n";
								 }
							 }
							 
							 if(newItems.size() > 1) {
								 tempBody += "===================\n";
							 }
							
						 }
						 
						if(pref.isNotifyEmail()) {
							sendMail.sendMail(user.getEmail(), "Notification Alert!", tempBody);
						}
						 
						if(pref.isNotifyPhone())  {
							log.info("Sending SMS to " + user.getCellPhone());
							tt.send(user.getCellPhone(),tempBody);
						}
						
						 
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