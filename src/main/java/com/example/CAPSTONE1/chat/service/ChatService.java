package com.example.CAPSTONE1.chat.service;

import com.example.CAPSTONE1.chat.dto.req.ChatReq;
import com.example.CAPSTONE1.chat.entity.Chat;
import com.example.CAPSTONE1.chat.repo.ChatRepo;
import com.example.CAPSTONE1.chatRoom.entity.ChatRoom;
import com.example.CAPSTONE1.chatRoom.repo.ChatRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepo chatRepo;
    private final ChatRoomRepo chatRoomRepo;

    public Chat createChat(Long roomId, String sender, String senderEmail, String message){
        ChatRoom chatRoom = chatRoomRepo.findById(roomId).orElseThrow(IllegalArgumentException::new);
        return chatRepo.save(Chat.createChat(chatRoom, sender, senderEmail, message));
    }

}
