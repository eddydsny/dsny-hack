package com.dsny.hack.domain;

import org.springframework.data.annotation.Id;

public class Event {
	
	@Id
	private Long id;
	private final String type;
	//Sequence ID is 1 base,
	private final short sequenceID;
	private String description;
	
	public Event(String type, short sequenceID) {
		this.type=type;
		this.sequenceID=sequenceID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public short getSequenceID() {
		return sequenceID;
	}
}
