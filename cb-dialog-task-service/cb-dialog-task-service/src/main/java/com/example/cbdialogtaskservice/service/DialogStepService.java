package com.example.cbdialogtaskservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cbdialogtaskservice.model.DialogStep;
import com.example.cbdialogtaskservice.repository.IDialogStepRepository;

@Service
public class DialogStepService {
	@Autowired
	private IDialogStepRepository dialogStepRepository;
	
	//Create operation
	public DialogStep create(String dialogId, String stepId, String step) {
		return dialogStepRepository.save(new DialogStep(dialogId, stepId, step));
	}
	//Retrieve operation
	public List<DialogStep> getAll() {
		return dialogStepRepository.findAll();
	}
	public List<DialogStep> getByDialogId(String dialogId) {
		return dialogStepRepository.getByDialogId(dialogId);
	}
	public DialogStep getByDialogAndStepId(String dialogId, String stepId) {
		return dialogStepRepository.getByDialogIdAndStepId(dialogId, stepId);
	}
	//Update Operation
	public DialogStep update(String dialogId, String stepId, String newStep) {
		DialogStep i = dialogStepRepository.getByDialogIdAndStepId(dialogId, stepId);
		i.setStep(newStep);
		return dialogStepRepository.save(i);
	}
	//Delete operation
	public void deleteAll() {
		dialogStepRepository.deleteAll();
	}
	public void delete(String dialogId, String stepId) {
		DialogStep i = dialogStepRepository.getByDialogIdAndStepId(dialogId, stepId);
		dialogStepRepository.delete(i);
	}
	public void deleteAllRelevantToDialog(String dialogId) {
		List<DialogStep> i = dialogStepRepository.getByDialogId(dialogId);
		dialogStepRepository.deleteAll(i);
	}
}
