package com.example.CAPSTONE1.chatRoom.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatRoom_id")
    private Long id;
    private String name;


    @Builder
    public ChatRoom(String name) {
        this.name = name;
    }

    public static ChatRoom createRoom(String name) {
        return ChatRoom.builder()
                .name(name)
                .build();
    }
}
