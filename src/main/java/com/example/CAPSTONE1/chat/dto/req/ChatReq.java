package com.example.CAPSTONE1.chat.dto.req;

import lombok.*;

public class ChatReq {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ChattingReq{
        private Long senderId;
        private String content;

    }

}
