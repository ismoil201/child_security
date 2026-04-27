package com.example.childsecurity.controller;

import com.example.childsecurity.dto.webrtc.OfferAnswerIceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebRtcSignalingController {

    private final SimpMessagingTemplate messagingTemplate;

    // Child yoki Parent dan kelgan signaling
    @MessageMapping("/webrtc/signal")
    public void signal(OfferAnswerIceDto dto) {
        // Hammasini tegishli child topic’iga uzatamiz
        messagingTemplate.convertAndSend(
                "/topic/webrtc/" + dto.getChildId(),
                dto
        );
    }
}
