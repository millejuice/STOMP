package com.example.CAPSTONE1.chatRoom.repo;

import com.example.CAPSTONE1.chat.entity.Chat;
import com.example.CAPSTONE1.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepo extends JpaRepository<ChatRoom, Long> {

}
