package com.vectorheat.WebChatApp.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.ZoneId;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        chatMessage.setTimestamp(Instant.now());
        return chatMessage;
    }


    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){

        //add username in web-socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        chatMessage.setTimestamp(Instant.now());
        return chatMessage;
    }
}
