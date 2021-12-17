package com.example.cbintentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cbintentservice.model.Intent;
import com.example.cbintentservice.repository.IIntentRepository;

@Service
public class IntentService {
	@Autowired
	private IIntentRepository intentRepository;
	
	//Create operation
	public Intent create(String name) {
		return intentRepository.save(new Intent(name));
	}
	//Retrieve operation
	public List<Intent> getAll(){
		return intentRepository.findAll();
	}
	public List<Intent> findIntentByName(String name) {
		return intentRepository.findByName(name);
	}
	//Update operation
	public Intent update(String intentId, String newName) {
		Intent p = intentRepository.findByIntentId(intentId);
		p.setName(newName);
		return intentRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		intentRepository.deleteAll();
	}
	public void delete(String name) {
		List<Intent> p = intentRepository.findByName(name);
		intentRepository.deleteAll(p);
	}
}
