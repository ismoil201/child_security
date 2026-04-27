package com.example.childsecurity.dto;

import lombok.Data;

@Data
public class LiveLocationDto {
    private Long childId;
    private Double latitude;
    private Double longitude;
}
