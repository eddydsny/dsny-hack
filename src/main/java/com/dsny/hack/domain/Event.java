package com.dsny.hack.domain;

import org.springframework.data.annotation.Id;

public class Event {

	@Id
	private String id;
	private String type;
	//Sequence ID is 1 base,
	private Short sequenceID;
	private String description;
	private Long transactionID;

	// status (New, Complete, Processing)
	private String status;

	public Event() {
		setStatus("New");
	}

	public Event(String type, short sequenceID) {
		this.type = type;
		this.sequenceID = sequenceID;
		setStatus("New");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Short getSequenceID() {
		return sequenceID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSequenceID(Short sequenceID) {
		this.sequenceID = sequenceID;
	}
}
