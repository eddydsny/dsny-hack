package com.dsny.hack.domain;

import org.springframework.data.annotation.Id;

public class Event {

	@Id
	private String id;
	private String type;
	//Sequence ID is 1 base,
	private Short sequenceID;
	private String description;
	private int transactionID;

	// status (New, Complete, Processing)
	private String status;

	public Event() {
		setStatus("New");
	}

	public Event(String type, short sequenceID, int transactionID) {
		this.type = type;
		this.sequenceID = sequenceID;
		this.transactionID = transactionID;
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

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSequenceID(Short sequenceID) {
		this.sequenceID = sequenceID;
	}
}
