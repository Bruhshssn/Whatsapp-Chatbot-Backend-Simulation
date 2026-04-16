package com.assignment.whatsappchatbot.service;

import com.assignment.whatsappchatbot.model.UserMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String sendReply(UserMessage userMessage) {
        if(userMessage.getMessage() == null) {
            return "Sorry, I don't understand your message!.";
        }

         return switch (userMessage.getMessage().trim().toLowerCase()) {
            case "hi" -> "Hello";
            case "bye" -> "Goodbye";
            default -> "Sorry, I don't understand your message!.";
        };
    }
}
