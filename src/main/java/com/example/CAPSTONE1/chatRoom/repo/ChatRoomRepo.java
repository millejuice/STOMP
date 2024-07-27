package com.example.CAPSTONE1.chatRoom.repo;

import com.example.CAPSTONE1.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepo extends JpaRepository<ChatRoom, Long> {
}
