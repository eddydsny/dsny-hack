package com.dsny.hack.service;

import java.util.List;

import com.dsny.hack.domain.Event;

public interface EventService {

	List<Event> getEvents();
	
	Event create(Event event);
	
	Event findByID(String id);

	Event update(Event event);

	void delete(String id);
}
