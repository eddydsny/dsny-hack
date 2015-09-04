package com.dsny.hack.persistence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dsny.hack.domain.Event;

public interface EventRepository extends MongoRepository<Event, String> {

	List<Event> findByStatus(String status);

}
