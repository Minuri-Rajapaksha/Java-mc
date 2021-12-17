package com.example.cbdialogtaskservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cbdialogtaskservice.model.DialogStep;

@Repository
public interface IDialogStepRepository extends MongoRepository<DialogStep, String> {
	public List<DialogStep> getByDialogId(String dialogId);
	public DialogStep getByDialogIdAndStepId(String dialogId, String stepId);
}
