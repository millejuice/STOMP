package com.example.CAPSTONE1.chat.repo;

import com.example.CAPSTONE1.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepo extends JpaRepository<Chat, Long> {
    List<Chat> findAllById(Long id);
}
