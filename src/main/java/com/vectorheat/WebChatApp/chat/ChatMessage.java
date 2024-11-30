package com.vectorheat.WebChatApp.chat;

import lombok.*;

import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content; //base-64 encoded string in case of image
    private String sender;
    private Instant timestamp;
    private MessageType type;
}
