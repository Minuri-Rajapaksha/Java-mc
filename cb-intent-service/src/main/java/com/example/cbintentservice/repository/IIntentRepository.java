package com.example.cbintentservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cbintentservice.model.Intent;

@Repository
public interface IIntentRepository extends MongoRepository<Intent, String> {
	public Intent findByIntentId(String intentId);
	public List<Intent> findByName(String name);
}
