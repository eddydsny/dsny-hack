package com.dsny.hack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dsny.hack.domain.Event;
import com.dsny.hack.persistence.repository.EventRepository;

@Service
public class EventProcessorImpl implements EventProcessor {
	
	@Autowired
	EventRepository eventRepo;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	void setEventProcessing(List<Event> events){
		for(Event event: events){
			event.setStatus("Processing");
		}
		eventRepo.save(events);
	}
	
	@Transactional
	public List<Event> processNewEvents() {
		List<Event> events = eventRepo.findByStatus("New");
		List<Event> processedEvents = new ArrayList<Event>();
		
		//events.stream().map(mapper)
		
		for(Event event: events){
			event.setStatus("Completed");
			processedEvents.add(event);
		}
		
		eventRepo.save(processedEvents);
		return processedEvents;
	}
}
