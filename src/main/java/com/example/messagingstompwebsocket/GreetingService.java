package com.example.messagingstompwebsocket;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
@Service
public class GreetingService {
	
	private final SimpMessagingTemplate simpMessagingTemplate;
	  private static final String WS_MESSAGE_TRANSFER_DESTINATION = "/topic/greetings";
	  private java.util.List<String> userNames = new ArrayList();
	  
	  GreetingService(SimpMessagingTemplate simpMessagingTemplate) {
	        this.simpMessagingTemplate = simpMessagingTemplate;
	    }


	  
	  public void sendMessages() {
		  System.out.println("sendMessage Greeting Service");
	        for (String userName : userNames) {
	        	System.out.println("users connected are :"+userName );
	            simpMessagingTemplate.convertAndSendToUser(userName, WS_MESSAGE_TRANSFER_DESTINATION,
	                    "Hallo " + userName + " at " + new Date().toString());
	        }
	    }
	  public void addUserName(String username) {
	        userNames.add(username);
	    }
	

}
