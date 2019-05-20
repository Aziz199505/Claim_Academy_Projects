package com.claim.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TestTwilio {
		
	 	public static final String ACCOUNT_SID = "AC00065630c60e3bb54fdbd2d4695d4b1e";
	    public static final String AUTH_TOKEN = "d04a8d9853c6a2d9798b712bd6cfd487";
	    public static final String FROM = "+13145829178";
	    
	    private String to;
	    private String body;
	    
	    public TestTwilio(String to, String body ) {
	    	this.to = to;
	    	this.body = body;
	    }
	    

	    public void send() {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("+1" + to),
	                new com.twilio.type.PhoneNumber(FROM),
	                body)
	            .create();

	        System.out.println(message.getSid());
	    }
}
