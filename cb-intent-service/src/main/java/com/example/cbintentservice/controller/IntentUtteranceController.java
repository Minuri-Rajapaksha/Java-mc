package com.example.cbintentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cbintentservice.model.IntentUtterance;
import com.example.cbintentservice.service.IntentUtteranceService;

@RestController
@RequestMapping("intentUtterances")
public class IntentUtteranceController {
	@Autowired
	private IntentUtteranceService intenUtteranceService;
	
	@PostMapping("/create")
	public String create(@RequestParam String intentId, @RequestParam String name) {
		IntentUtterance p = intenUtteranceService.create(intentId, name);
		return p.toString();
	}
	
	@GetMapping("/getByName")
	public IntentUtterance getIntent(@RequestParam String name) {
		return intenUtteranceService.getByUtterance(name);
	}
	
	@GetMapping("/getById")
	public List<IntentUtterance> getIntentbyId(@RequestParam String intentId) {
		return intenUtteranceService.getById(intentId);
	}
	@GetMapping("/getAll")
	public List<IntentUtterance> getAll(){
		return intenUtteranceService.getAll();
	}
	@PatchMapping("/update")
	public String update(@RequestParam String intentId, @RequestParam String utterance, @RequestParam String newUtterance) {
		IntentUtterance p = intenUtteranceService.update(intentId, utterance, newUtterance);
		return p.toString();
	}
	@DeleteMapping("/delete")
	public String delete(@RequestParam String intentId, @RequestParam String utterance) {
		intenUtteranceService.delete(intentId, utterance);
		return "Deleted "+ utterance;
	}
	@DeleteMapping ("/deleteAll")
	public String deleteAll() {
		intenUtteranceService.deleteAll();
		return "Deleted all records";
	}
}
