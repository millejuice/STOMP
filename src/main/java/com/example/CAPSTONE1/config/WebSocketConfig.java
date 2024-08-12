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
        registry.setApplicationDestinationPrefixes("/send");
        //해당 주소를 구독하고 있는 클라이언트들에게 메세지 전달(발신). cli는 구독할 시 이 주소로 요청해야 함
        registry.enableSimpleBroker("/room");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/capstone").setAllowedOriginPatterns("*")   //SockJS 연결 주소
                .withSockJS(); //버전 낮은 브라우저에서도 적용 가능
        // 주소 : ws://localhost:8080/capstone 호출하면 WebSocket 연결
        //send를 통해 메세지를 보내면 /room으로 구독하고 있는 클라이언트들에게 메세지 전달
    }
}
