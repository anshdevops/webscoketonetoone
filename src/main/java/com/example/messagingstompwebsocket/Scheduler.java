package com.example.messagingstompwebsocket;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class Scheduler {
	
	 private final GreetingService greetingService;

	    Scheduler(GreetingService greetingService) {
	        this.greetingService = greetingService;
	    }

	    @Scheduled(fixedRateString = "6000", initialDelayString = "0")
	    public void schedulingTask() {
	        System.out.println(("Send messages due to schedule"));
	        greetingService.sendMessages();
	    }

}
