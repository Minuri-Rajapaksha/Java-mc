package com.example.cbconversationmanagerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${app.intentService}")
	private String intentService;
	
	@Value("${app.dialogService}")
	private String dialogService;
	
	@GetMapping("/getIntent")
	public IntentUtterance getIntent(@RequestParam String utterance) {
		StringBuilder url = new StringBuilder(intentService);
		url.append("/intentUtterances/getByName?name=");
		url.append(utterance);
		
		IntentUtterance intent = webClientBuilder.build()
			.get()
			.uri(url.toString())
			.retrieve()
			.bodyToMono(IntentUtterance.class)
			.block();
		return intent;
	}
	
	@GetMapping("/getDialogTask")
	public Dialog getDialogTask(@RequestParam String utterance) {
		StringBuilder url = new StringBuilder(dialogService);
		url.append("/dialogs/getDialogByIntentId?intentId=");
		
		IntentUtterance intent = getIntent(utterance);
		url.append(intent.getIntentId());
		Dialog dialog = webClientBuilder.build()
			.get()
			.uri(url.toString())
			.retrieve()
			.bodyToMono(Dialog.class)
			.block();
		return dialog;
	}
	
	@GetMapping("/getBotReply")
	public Object[] getBotReply(@RequestParam String utterance) {
		StringBuilder url = new StringBuilder(dialogService);
		url.append("/dialogSteps/getByDialogId?dialogId=");
		
		Dialog dialog = getDialogTask(utterance);
		url.append(dialog.getDialogId());
		Object[] dialogStep = webClientBuilder.build()
			.get()
			.uri(url.toString())
			.retrieve()
			.bodyToMono(Object[].class)
			.block();
		return dialogStep;
	}
}
