package com.example.CAPSTONE1.chat.repo;

import com.example.CAPSTONE1.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepo extends JpaRepository<Chat, Long> {
}
