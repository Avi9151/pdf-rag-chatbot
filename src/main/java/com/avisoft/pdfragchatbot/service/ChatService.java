package com.avisoft.pdfragchatbot.service;

import com.avisoft.pdfragchatbot.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ChatResponse ask(String message) {
        String answer = chatClient
                .prompt()
                .user(message)
                .call()
                .content();

        return new ChatResponse(answer);
    }
}
