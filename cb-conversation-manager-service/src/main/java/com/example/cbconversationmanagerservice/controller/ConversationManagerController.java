package com.example.cbconversationmanagerservice.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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
@RequestMapping("conversationManagers")
public class ConversationManagerController {
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${app.intentService}")
	private String intentService;
	
	@Value("${app.dialogService}")
	private String dialogService;
	
	Logger logger = LoggerFactory.getLogger(ConversationManagerController.class); 
	
	/**
	 * API end point which returns intent object when an utterance is given
	 * @param utterance
	 * @return intent
	 */
	@GetMapping("/getIntent")
	public IntentUtterance getIntent(@RequestParam String utterance) {
		try {
			logger.trace("conversationManagers getIntent endpoint is called...");
			StringBuilder url = new StringBuilder(intentService);
			url.append("/intentUtterances/getByName?name=");
			url.append(utterance);
			IntentUtterance intent = webClientBuilder.build().get().uri(url.toString()).retrieve()
					.bodyToMono(IntentUtterance.class).block();
			return intent;
		} catch (Exception e) {

			logger.error("Error in ConversationManagerController's getIntent: " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * API end point which returns dialog object when an utterance is given
	 * @param utterance
	 * @return dialog
	 */
	@GetMapping("/getDialogTask")
	public Dialog getDialogTask(@RequestParam String utterance) {
		try {
			logger.trace("conversationManagers getDialogTask endpoint is called...");
			StringBuilder url = new StringBuilder(dialogService);
			url.append("/dialogs/getDialogByIntentId?intentId=");
			IntentUtterance intent = getIntent(utterance);
			if(intent == null) return null;
			
			url.append(intent.getIntentId());
			Dialog dialog = webClientBuilder.build().get().uri(url.toString()).retrieve().bodyToMono(Dialog.class)
					.block();
			return dialog;
		} catch (Exception e) {
			logger.error("Error in ConversationManagerController's getDialogTask: " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * API end point which returns possible bot reply when an utterance is given
	 * @param utterance
	 * @return object[]
	 */
	@GetMapping("/getBotReply")
	public Object[] getBotReply(@RequestParam String utterance) {
		try {
			logger.trace("conversationManagers getBotReply endpoint is called...");
			StringBuilder url = new StringBuilder(dialogService);
			url.append("/dialogSteps/getByDialogId?dialogId=");
			Dialog dialog = getDialogTask(utterance);
			if(dialog == null) return null;
			
			url.append(dialog.getDialogId());
			Object[] dialogStep = webClientBuilder.build().get().uri(url.toString()).retrieve()
					.bodyToMono(Object[].class).block();
			return dialogStep;
		} catch (Exception e) {
			logger.error("Error in ConversationManagerController's getBotReply: " + e.getMessage());
			return null;
		}
	} 
}
