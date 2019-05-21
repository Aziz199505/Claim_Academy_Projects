package com.claim.controller;


import com.twilio.rest.api.v2010.account.Message;

public class TestTwilio {

	    public static final String FROM = "+13145829178";
	    
	    
	    

	    public void send(String to, String body) {
	        
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("+1" + to),
	                new com.twilio.type.PhoneNumber(FROM),
	                body)
	            .create();
	        
	        

	        System.out.println(message.getSid());
	    }
	    
	    
	/*
	 * public void sendSMS(String to, String body) { try { TwilioRestClient client =
	 * new TwilioRestClient(null);
	 * 
	 * // Build a filter for the MessageList List<NameValuePair> params = new
	 * ArrayList<NameValuePair>(); params.add(new BasicNameValuePair("Body",
	 * "Hello, World!")); params.add(new BasicNameValuePair("To", "+15555555555"));
	 * //Add real number here params.add(new BasicNameValuePair("From", to));
	 * 
	 * MessageFactory messageFactory = client.getAccount().getMessageFactory();
	 * Message message = messageFactory.create(params);
	 * System.out.println(message.getSid()); } catch (TwilioRestException e) {
	 * System.out.println(e.getErrorMessage()); } }
	 */
}
