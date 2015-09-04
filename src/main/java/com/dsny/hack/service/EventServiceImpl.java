package com.dsny.hack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsny.hack.domain.Event;
import com.dsny.hack.persistence.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepo;
	
	@Override
	public List<Event> getEvents() {
		return eventRepo.findAll();
	}
}
