package com.example.cbdialogtaskservice.model;

import org.springframework.data.annotation.Id;

public class DialogStep {
	@Id
	String id;
	String dialogId;
	String stepId;
	String step;

	public String getDialogId() {
		return dialogId;
	}
	public void setDialogId(String dialogId) {
		this.dialogId = dialogId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	
	public DialogStep(String dialogId, String stepId, String step) {
		this.dialogId = dialogId;
		this.stepId = stepId;
		this.step = step;
	}
}
