package com.example.cbconversationmanagerservice.model;

import org.springframework.data.annotation.Id;

public class Dialog {
	@Id
	String dialogId;
	String intentId;
	String name;

	public String getDialogId() {
		return dialogId;
	}
	public void setDialogId(String dialogId) {
		this.dialogId = dialogId;
	}
	public String getIntentId() {
		return intentId;
	}
	public void setIntentId(String intentId) {
		this.intentId = intentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Dialog(String name, String intentId) {
		this.name = name;
		this.intentId = intentId;
	}
}
