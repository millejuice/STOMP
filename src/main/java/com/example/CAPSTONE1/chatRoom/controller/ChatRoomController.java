package com.example.CAPSTONE1.chatRoom.controller;

import com.example.CAPSTONE1.chatRoom.repo.ChatRoomRepo;
import com.example.CAPSTONE1.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomRepo chatRoomRepo;
    private final ChatRoomService chatRoomService;
}
