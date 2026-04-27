package com.example.childsecurity.controller;

import com.example.childsecurity.model.Child;
import com.example.childsecurity.model.Location;
import com.example.childsecurity.repository.ChildRepository;
import com.example.childsecurity.service.LocationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final ChildRepository childRepository;

    // 📍 BOLA TOMONIDAN GPS YUBORISH
    @PostMapping("/update")
    public Location updateLocation(@RequestBody LocationRequest request) {
        Child child = childRepository.findById(request.getChildId())
                .orElseThrow(() -> new RuntimeException("Child not found"));

        return locationService.saveLocation(
                child,
                request.getLatitude(),
                request.getLongitude()
        );
    }

    // 📍 OTA-ONA UCHUN OXIRGI LOCATION
    @GetMapping("/last/{childId}")
    public Location getLastLocation(@PathVariable Long childId) {
        return locationService.getLastLocation(childId);
    }

    // 📍 LOCATION TARIXI
    @GetMapping("/history/{childId}")
    public List<Location> getHistory(@PathVariable Long childId) {
        return locationService.getHistory(childId);
    }

    @Data
    static class LocationRequest {
        private Long childId;
        private Double latitude;
        private Double longitude;
    }
}
