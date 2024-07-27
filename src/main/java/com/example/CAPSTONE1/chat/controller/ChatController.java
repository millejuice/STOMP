package com.example.CAPSTONE1.chat.controller;

import com.example.CAPSTONE1.chat.dto.req.ChatReq;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/{chatRoomId}/message")
    @SendTo("/capstone/{chatRoomId}") // /capstone/{chatRoomId}를 구독한 모든곳에 메세지 전달
    public void chat(@DestinationVariable("chatRoomId") Long chatRoomId, ChatReq req){

    }
}
