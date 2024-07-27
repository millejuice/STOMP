package com.example.CAPSTONE1.chat.service;

import com.example.CAPSTONE1.chat.dto.req.ChatReq;
import com.example.CAPSTONE1.chat.repo.ChatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepo chatRepo;

    public void save(Long chatRoomId,ChatReq.ChattingReq req){
        chatRepo.save();

}
