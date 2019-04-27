package com.claim.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TestTwilio {
	 public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	    public static final String AUTH_TOKEN = "your_auth_token";

	    public static void main(String[] args) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("+15558675310"),
	                new com.twilio.type.PhoneNumber("+15017122661"),
	                "body")
	            .create();

	        System.out.println(message.getSid());
	    }
}
