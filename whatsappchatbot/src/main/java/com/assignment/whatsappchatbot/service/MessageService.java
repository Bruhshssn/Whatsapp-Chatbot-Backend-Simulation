package com.assignment.whatsappchatbot.service;

import com.assignment.whatsappchatbot.model.UserMessage;
import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String sendReply(UserMessage userMessage) {
        if(userMessage.getMessage() == null) {
            return "Sorry, I don't understand your message!.";
        }

         return switch (userMessage.getMessage().trim().toLowerCase()) {
            case "hi" -> "Hello! How can I help you today";
            case "bye" -> "Goodbye! Have a nice day";
            default -> "Sorry, I don't understand your message!.";
        };
    }

    public String generateId(){
        return NanoIdUtils.randomNanoId();
    }
}
