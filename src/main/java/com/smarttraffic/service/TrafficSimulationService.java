package com.smarttraffic.service;

import com.smarttraffic.model.IntersectionReading;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TrafficSimulationService {

    private static final List<String> INTERSECTIONS = List.of("A1", "A2", "B1", "B2");

    public List<IntersectionReading> currentReadings() {
        long now = System.currentTimeMillis();

        return INTERSECTIONS.stream()
                .map(id -> new IntersectionReading(
                        id,
                        ThreadLocalRandom.current().nextInt(10, 80),
                        ThreadLocalRandom.current().nextInt(10, 80),
                        now
                ))
                .toList();
    }
}
