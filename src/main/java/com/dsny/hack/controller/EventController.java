package com.dsny.hack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsny.hack.domain.Event;
import com.dsny.hack.service.EventService;

@RestController
@RequestMapping("event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping("list")
	public List<Event> getEvents(){
		return eventService.getEvents();
	}
}
