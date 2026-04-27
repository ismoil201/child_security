package com.example.childsecurity.service;

import com.example.childsecurity.model.Child;
import com.example.childsecurity.model.Location;
import com.example.childsecurity.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public Location saveLocation(Child child, Double lat, Double lng) {
        Location location = new Location();
        location.setLatitude(lat);
        location.setLongitude(lng);
        location.setChild(child);
        return locationRepository.save(location);
    }

    public Location getLastLocation(Long childId) {
        return locationRepository.findTopByChildIdOrderByCreatedAtDesc(childId);
    }

    public List<Location> getHistory(Long childId) {
        return locationRepository.findByChildIdOrderByCreatedAtDesc(childId);
    }
}
