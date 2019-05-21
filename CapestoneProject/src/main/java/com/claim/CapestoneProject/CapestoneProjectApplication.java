package com.claim.CapestoneProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

@SpringBootApplication
@EnableScheduling
public class CapestoneProjectApplication {

	public static final String ACCOUNT_SID = "AC00065630c60e3bb54fdbd2d4695d4b1e";
    public static final String AUTH_TOKEN = "d04a8d9853c6a2d9798b712bd6cfd487";
    public static final String FROM = "+13145829178";
	
	public static void main(String[] args) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    	
    	ListenableFuture<ResourceSet<Message>> future = Message.reader().readAsync();
    	Futures.addCallback(
    	    future,
    	    new FutureCallback<ResourceSet<Message>>() {
    	        public void onSuccess(ResourceSet<Message> messages) {
    	            for (Message message : messages) {
    	                System.out.println(message.getSid() + " : " + message.getStatus());
    	             }
    	         }
    	         public void onFailure(Throwable t) {
    	             System.out.println("Failed to get message status: " + t.getMessage());
    	         }
    	     });
    	     
		
		SpringApplication.run(CapestoneProjectApplication.class, args);
	}

}
