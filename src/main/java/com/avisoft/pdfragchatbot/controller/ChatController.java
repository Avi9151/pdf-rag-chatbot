package com.avisoft.pdfragchatbot.controller;

import com.avisoft.pdfragchatbot.dto.ChatRequest;
import com.avisoft.pdfragchatbot.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @PostMapping
    public String chat(@RequestBody ChatRequest request){
        return chatService.chat(request.message());
    }
}
