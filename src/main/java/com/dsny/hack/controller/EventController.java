package com.dsny.hack.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsny.hack.domain.Event;
import com.dsny.hack.service.EventService;

@RestController
@RequestMapping("event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping()
	public List<Event> list(){
		return eventService.getEvents();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Event create(@RequestBody @Valid Event event){
		return eventService.create(event);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Event get(@PathVariable("id") String id) {
		return eventService.findByID(id);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Event update(@PathVariable("id") long id, @RequestBody @Valid Event event) {
		return eventService.update(event);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		eventService.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
