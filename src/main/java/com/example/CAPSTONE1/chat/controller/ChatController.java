package com.example.CAPSTONE1.chat.controller;

import com.example.CAPSTONE1.chat.dto.req.ChatReq;
import com.example.CAPSTONE1.chat.entity.Chat;
import com.example.CAPSTONE1.chat.service.ChatService;
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
    private final ChatService chatService;

    @MessageMapping("/{chatRoomId}/message") //여기로 전송되면 메서드 호출
    @SendTo("/sub/{chatRoomId}") // /capstone/{chatRoomId}를 구독한 모든곳에 메세지 전달. broker에서 적용한거 앞에 붙여줘야 함
    public void chat(@DestinationVariable("chatRoomId") Long chatRoomId, Chat req){
        chatService.createChat(chatRoomId, req.getSender(), req.getSenderEmail(), req.getMessage());

    }
}
