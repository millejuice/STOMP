package com.example.CAPSTONE1.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //클라이언트에서 보낸 메세지를 받을 prefix (수신)
//        /pub로 시작하는 stomp 메세지는 @MessageMapping 메서드로 라우팅
        registry.setApplicationDestinationPrefixes("/pub");
        // /sub를 구독하고 있는 클라이언트들에게 메세지 전달(발신). cli는 구독할 시 이 주소로 요청해야 함
//        /sub로 시작하는 메세지를 @MessageMapping이 아닌, 브로커로 라우팅
        registry.enableSimpleBroker("/sub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/capstone").setAllowedOriginPatterns("*");
        // 주소 : ws://localhost:8080/capstone 호출하면 WebSocket 연결
        //send를 통해 메세지를 보내면 /room으로 구독하고 있는 클라이언트들에게 메세지 전달
    }
}
