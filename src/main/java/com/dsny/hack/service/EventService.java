package com.dsny.hack.service;

import java.util.List;

import com.dsny.hack.domain.Event;

public interface EventService {

	List<Event> getEvents();
	
	Event create(Event event);
	
	Event findByID(Long id);

	Event update(Event event);

	void delete(long id);
}
