package com.dsny.hack.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dsny.hack.domain.Event;
import com.dsny.hack.persistence.repository.EventRepository;

@Service
public class EventProcessorImpl implements EventProcessor {

	@Autowired
	EventRepository eventRepo;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	void setEventProcessing(List<Event> events) {
		for (Event event : events) {
			event.setStatus("Processing");
		}
		eventRepo.save(events);
	}

	@Scheduled(fixedRate = 5000)
	@Transactional
	public void processNewEvents() {
		List<Event> events = eventRepo.findByStatus("New");
		// group by transactionID
		Map<Long, List<Event>> eventMap = events.stream().collect(
				Collectors.groupingBy(Event::getTransactionID));

		if (eventMap.size() > 0) {
			for (Entry<Long, List<Event>> entry : eventMap.entrySet()) {
				boolean isAllEventReady = processEvents(entry.getValue());
				if (isAllEventReady) {
					entry.getValue().forEach((e) -> e.setStatus("Completed"));
				} else {
					entry.getValue().forEach((e) -> e.setStatus("New"));
				}
				eventRepo.save(entry.getValue());
			}
		}
	}

	boolean processEvents(List<Event> events) {
		boolean isAllEventReady = true;
		List<Event> sortedList = events
				.stream()
				.sorted((e1, e2) -> e1.getSequenceID().compareTo(
						e2.getSequenceID())).collect(Collectors.toList());

		int currentSequence = 0;
		for (Event event : sortedList) {
			if (currentSequence +1 != event.getSequenceID()) {
				isAllEventReady = false;
				break;
			}else{
				currentSequence = currentSequence + 1;
			}
		}

		return isAllEventReady;
	}
}
