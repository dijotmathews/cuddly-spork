package com.dijo.openaidemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient){
        this.chatClient = chatClient;
    }


    @GetMapping("/jokes")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a dad joke") String message){
        return chatClient.prompt().user(message).call().content();
    }
}
