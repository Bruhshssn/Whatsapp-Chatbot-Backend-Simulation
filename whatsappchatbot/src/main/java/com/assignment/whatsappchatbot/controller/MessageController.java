package com.assignment.whatsappchatbot.controller;

import com.assignment.whatsappchatbot.model.UserMessage;
import com.assignment.whatsappchatbot.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/webhook")
public class MessageController {

    @Autowired
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public String sendMessage(@RequestBody UserMessage message) {
        String messageId = messageService.generateId();
        log.info("from: {} , messageId: {} , messageType: text , message: {}", message.getFrom(), messageId,message.getMessage());
        return messageService.sendReply(message);
    }
}
