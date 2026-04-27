package com.example.childsecurity.controller;

import com.example.childsecurity.dto.LiveLocationDto;
import com.example.childsecurity.model.Child;
import com.example.childsecurity.service.LocationService;
import com.example.childsecurity.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LiveLocationController {

    private final SimpMessagingTemplate messagingTemplate;
    private final LocationService locationService;
    private final ChildRepository childRepository;

    // 📍 Child -> Server (WebSocket)
    @MessageMapping("/location/live")
    public void receiveLiveLocation(LiveLocationDto dto) {

        Child child = childRepository.findById(dto.getChildId())
                .orElseThrow(() -> new RuntimeException("Child not found"));

        // DB ga ham saqlab qo‘yamiz
        locationService.saveLocation(
                child,
                dto.getLatitude(),
                dto.getLongitude()
        );

        // Parent’ga LIVE yuboramiz
        messagingTemplate.convertAndSend(
                "/topic/child/" + dto.getChildId(),
                dto
        );
    }
}
