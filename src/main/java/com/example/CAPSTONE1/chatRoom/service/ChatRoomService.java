package com.example.CAPSTONE1.chatRoom.service;

import com.example.CAPSTONE1.chatRoom.entity.ChatRoom;
import com.example.CAPSTONE1.chatRoom.repo.ChatRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepo chatRoomRepo;

    public List<ChatRoom> findAll(){
        return chatRoomRepo.findAll();
    }

    public ChatRoom findChatRoomById(Long id){
        return chatRoomRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void createChatRoom(String name){
        chatRoomRepo.save(ChatRoom.createRoom(name));
    }
}
