package com.example.childsecurity.dto.webrtc;

import lombok.Data;

@Data
public class OfferAnswerIceDto {
    private Long childId;
    private String type; // "offer" | "answer" | "ice"
    private String sdp;  // offer/answer SDP
    private String candidate; // ICE candidate (json/string)
}
