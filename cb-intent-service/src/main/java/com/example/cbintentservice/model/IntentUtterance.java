package com.example.cbintentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IntentUtterance {
	@Id
	String id;
	String intentId;
	String utterance;
	
	public IntentUtterance(String intentId, String utterance) {
		super();
		this.intentId = intentId;
		this.utterance = utterance;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIntentId() {
		return intentId;
	}
	public void setIntentId(String intentId) {
		this.intentId = intentId;
	}
	public String getUtterance() {
		return utterance;
	}
	public void setUtterance(String utterance) {
		this.utterance = utterance;
	}
}
