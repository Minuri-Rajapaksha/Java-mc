package com.example.cbconversationmanagerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.cbconversationmanagerservice.model.Dialog;
import com.example.cbconversationmanagerservice.model.DialogStep;
import com.example.cbconversationmanagerservice.model.IntentUtterance;

@RestController
@RequestMapping("intents")
public class ConversationManagerController {
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/getIntent")
	public IntentUtterance getIntent(@RequestParam String utterance) {
		IntentUtterance intent = webClientBuilder.build()
			.get()
			.uri("http://localhost:8082/intentUtterances/getByName?name=" + utterance)
			.retrieve()
			.bodyToMono(IntentUtterance.class)
			.block();
		return intent;
	}
	
	@GetMapping("/getDialogTask")
	public Dialog getDialogTask(@RequestParam String utterance) {
		IntentUtterance intent = getIntent(utterance);
		Dialog dialog = webClientBuilder.build()
			.get()
			.uri("http://localhost:8083/dialogs/getByIntentId?intentId=" + intent.getIntentId())
			.retrieve()
			.bodyToMono(Dialog.class)
			.block();
		return dialog;
	}
	
	@GetMapping("/getBotReply")
	public Object[] getBotReply(@RequestParam String utterance) {
		Dialog dialog = getDialogTask(utterance);
		Object[] dialogStep = webClientBuilder.build()
			.get()
			.uri("http://localhost:8083/dialogSteps/getByDialogId?dialogId=" + dialog.getDialogId())
			.retrieve()
			.bodyToMono(Object[].class)
			.block();
		return dialogStep;
	}
}
