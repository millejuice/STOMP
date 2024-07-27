package com.example.CAPSTONE1.chat.entity;

import com.example.CAPSTONE1.chatRoom.entity.ChatRoom;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private ChatRoom room;

    private String sender;

    private String senderEmail;

    @Column(columnDefinition = "TEXT")
    private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime sendDate;

    @Builder
    public Chat(ChatRoom room, String sender, String senderEmail, String message) {
        this.room = room;
        this.sender = sender;
        this.senderEmail = senderEmail;
        this.message = message;
        this.sendDate = LocalDateTime.now();
    }

    /**
     * 채팅 생성
     * @param room 채팅 방
     * @param sender 보낸이
     * @param message 내용
     * @return Chat Entity
     */
    public static Chat createChat(ChatRoom room, String sender, String senderEmail, String message) {
        return Chat.builder()
                .room(room)
                .sender(sender)
                .senderEmail(senderEmail)
                .message(message)
                .build();
    }
}
