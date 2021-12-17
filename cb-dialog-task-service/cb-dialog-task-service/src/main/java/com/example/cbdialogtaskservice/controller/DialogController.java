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

import com.example.cbdialogtaskservice.model.Dialog;
import com.example.cbdialogtaskservice.service.DialogService;

@RestController
@RequestMapping("dialogs")
public class DialogController {
	@Autowired
	private DialogService dialogService;
	
	@PostMapping("/create")
	public String create(@RequestParam String name, @RequestParam String intentId) {
		Dialog p = dialogService.create(name, intentId);
		return p.toString();
	}
	
	@GetMapping("/getByName")
	public Dialog getDialogByIntentId(@RequestParam String name) {
		return dialogService.findDialogByIntentId(name);
	}
	@GetMapping("/getAll")
	public List<Dialog> getAll(){
		return dialogService.getAll();
	}
	@PatchMapping("/update")
	public String update(@RequestParam String dialogId, @RequestParam String newName, @RequestParam String newIntentId) {
		Dialog p = dialogService.update(dialogId, newName, newIntentId);
		return p.toString();
	}
	@DeleteMapping("/delete")
	public String delete(@RequestParam String name) {
		dialogService.delete(name);
		return "Deleted "+ name;
	}
	@DeleteMapping ("/deleteAll")
	public String deleteAll() {
		dialogService.deleteAll();
		return "Deleted all records";
	}
}
