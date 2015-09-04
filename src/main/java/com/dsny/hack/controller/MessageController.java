package com.dsny.hack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.dsny.hack.domain.Event;
import com.dsny.hack.service.EventService;

@Controller
public class MessageController {

	@Autowired
	EventService eventService;
	
	@MessageMapping("/add")
	@SendTo("/topic/events")
	public Event create(Event event) throws Exception {
		return eventService.create(event);
	}
}
