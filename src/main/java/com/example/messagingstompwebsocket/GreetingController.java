package com.example.messagingstompwebsocket;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


	  private final GreetingService greetingService;
	
	@Autowired
	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	@MessageMapping("/hello")
	@SendToUser("/topic/greetings")
	public Greeting greeting(HelloMessage message,Principal principal) throws Exception {
		System.out.println("Greetings Executed");
		
	
		
		greetingService.addUserName(principal.getName()); // store UUID
		System.out.println(principal.getName());
		
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!. Your UUID IS :"+principal.getName());
	}
	
	

}
