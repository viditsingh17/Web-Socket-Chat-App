package com.vectorheat.WebChatApp.chat;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content; //base-64 encoded string in case of image
    private String sender;
    private LocalDateTime timestamp;
    private MessageType type;
}
