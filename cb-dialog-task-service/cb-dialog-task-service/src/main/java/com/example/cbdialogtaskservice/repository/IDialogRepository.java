package com.example.cbdialogtaskservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cbdialogtaskservice.model.Dialog;

@Repository
public interface IDialogRepository extends MongoRepository<Dialog, String> {
	public Dialog findByIntentId(String intentId);
	public Dialog findByDialogId(String dialogId);
}
