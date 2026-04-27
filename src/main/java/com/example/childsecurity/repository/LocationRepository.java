package com.example.childsecurity.repository;

import com.example.childsecurity.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    // Bola bo‘yicha barcha location’lar (oxirgisi oxirida)
    List<Location> findByChildIdOrderByCreatedAtDesc(Long childId);

    // Oxirgi location (ENG MUHIM)
    Location findTopByChildIdOrderByCreatedAtDesc(Long childId);
}
