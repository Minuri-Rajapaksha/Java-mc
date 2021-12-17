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

import com.example.cbintentservice.model.Intent;
import com.example.cbintentservice.service.IntentService;

@RestController
@RequestMapping("intents")
public class IntentController {
	@Autowired
	private IntentService intentService;
	
	@PostMapping("/create")
	public String create(@RequestParam String name) {
		Intent p = intentService.create(name);
		return p.toString();
	}
	
	@GetMapping("/getByName")
	public List<Intent> getIntent(@RequestParam String name) {
		return intentService.findIntentByName(name);
	}
	@GetMapping("/getAll")
	public List<Intent> getAll(){
		return intentService.getAll();
	}
	@PatchMapping("/update")
	public String update(@RequestParam String intentId, @RequestParam String newName) {
		Intent p = intentService.update(intentId, newName);
		return p.toString();
	}
	@DeleteMapping("/delete")
	public String delete(@RequestParam String name) {
		intentService.delete(name);
		return "Deleted "+ name;
	}
	@DeleteMapping ("/deleteAll")
	public String deleteAll() {
		intentService.deleteAll();
		return "Deleted all records";
	}
}
