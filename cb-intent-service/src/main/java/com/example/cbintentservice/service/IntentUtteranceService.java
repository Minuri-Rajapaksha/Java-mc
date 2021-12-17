package com.example.cbintentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cbintentservice.model.IntentUtterance;
import com.example.cbintentservice.repository.IIntentUtteranceRepository;

@Service
public class IntentUtteranceService {
	@Autowired
	private IIntentUtteranceRepository intentUtteranceRepository;
	
	//Create operation
	public IntentUtterance create(String intentId, String utterance) {
		return intentUtteranceRepository.save(new IntentUtterance(intentId, utterance));
	}
	//Retrieve operation
	public List<IntentUtterance> getAll() {
		return intentUtteranceRepository.findAll();
	}
	public List<IntentUtterance> getById(String intentId) {
		return intentUtteranceRepository.getByIntentId(intentId);
	}
	public IntentUtterance getByUtterance(String utterance) {
		return intentUtteranceRepository.getByUtterance(utterance);
	}
	//Update Operation
	public IntentUtterance update(String intentId, String utterance, String newUtterance) {
		IntentUtterance i = intentUtteranceRepository.getByUtteranceAndIntentId(intentId, utterance);
		
		i.setUtterance(newUtterance);
		return intentUtteranceRepository.save(i);
	}
	//Delete operation
	public void deleteAll() {
		intentUtteranceRepository.deleteAll();
	}
	public void delete(String intentId, String utterance) {
		IntentUtterance i = intentUtteranceRepository.getByUtteranceAndIntentId(intentId, utterance);
		intentUtteranceRepository.delete(i);
	}
}
