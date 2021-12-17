package com.example.cbintentservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cbintentservice.model.IntentUtterance;

@Repository
public interface IIntentUtteranceRepository extends MongoRepository<IntentUtterance, String>{
	public List<IntentUtterance> getByIntentId(String intentId);
	public IntentUtterance getByUtterance(String utterance);
	public IntentUtterance getByUtteranceAndIntentId(String utterance, String intentId);
}
