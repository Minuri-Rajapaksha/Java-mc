package com.example.cbdialogtaskservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cbdialogtaskservice.model.DialogStep;
import com.example.cbdialogtaskservice.service.DialogStepService;

@RestController
@RequestMapping("dialogStep")
public class DialogStepController {
	@Autowired
	private DialogStepService dialogStepService;
	
	@PostMapping("/create")
	public String create(@RequestParam String dialogId, @RequestParam String stepId, @RequestParam String step) {
		DialogStep p = dialogStepService.create(dialogId, stepId, step);
		return p.toString();
	}
	
	@GetMapping("/getByDialogId")
	public List<DialogStep> getByDialogId(@RequestParam String dialogId) {
		return dialogStepService.getByDialogId(dialogId);
	}
	
	@GetMapping("/getByDialogAndStepId")
	public DialogStep getByDialogAndStepId(@RequestParam String dialogId, @RequestParam String stepId) {
	return dialogStepService.getByDialogAndStepId(dialogId, stepId);
	}
	
	@GetMapping("/getAll")
	public List<DialogStep> getAll(){
		return dialogStepService.getAll();
	}
	
	@PatchMapping("/update")
	public String update(@RequestParam String dialogId, @RequestParam String stepId, @RequestParam String newStep) {
		DialogStep p = dialogStepService.update(dialogId, stepId, newStep);
		return p.toString();
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam String dialogId, @RequestParam String stepId) {
		dialogStepService.delete(dialogId, stepId);
		return "Deleted "+ dialogId;
	}
	
	@DeleteMapping ("/deleteAll")
	public String deleteAll() {
		dialogStepService.deleteAll();
		return "Deleted all records";
	}
	
	@DeleteMapping("/deleteAllRelevantToDialog")
	public String deleteAllRelevantToDialog(@RequestParam String dialogId) {
		dialogStepService.deleteAllRelevantToDialog(dialogId);
		return "Deleted "+ dialogId;
	}
}
