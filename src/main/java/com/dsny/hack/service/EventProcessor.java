package com.dsny.hack.service;

import java.util.List;

import com.dsny.hack.domain.Event;

public interface EventProcessor {
	
	List<Event> processNewEvents();
}
