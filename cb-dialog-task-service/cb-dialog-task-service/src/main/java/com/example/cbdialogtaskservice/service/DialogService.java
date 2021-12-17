package com.example.cbdialogtaskservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cbdialogtaskservice.model.Dialog;
import com.example.cbdialogtaskservice.repository.IDialogRepository;

@Service
public class DialogService {
	@Autowired
	private IDialogRepository dialogRepository;
	
	//Create operation
	public Dialog create(String name, String intentId) {
		return dialogRepository.save(new Dialog(name, intentId));
	}
	//Retrieve operation
	public List<Dialog> getAll(){
		return dialogRepository.findAll();
	}
	public Dialog findDialogByIntentId(String intentId) {
		return dialogRepository.findByIntentId(intentId);
	}
	//Update operation
	public Dialog update(String dialogId, String newName, String newIntentId) {
		Dialog p = dialogRepository.findByDialogId(dialogId);
		p.setName(newName);
		p.setIntentId(newIntentId);
		return dialogRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		dialogRepository.deleteAll();
	}
	public void delete(String name) {
		Dialog p = dialogRepository.findByDialogId(name);
		dialogRepository.delete(p);
	}
}
