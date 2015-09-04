package com.dsny.hack.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dsny.hack.domain.Event;

public interface EventRepository extends MongoRepository<Event, Long> {

}
