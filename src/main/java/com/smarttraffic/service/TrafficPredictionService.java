package com.smarttraffic.service;

import com.smarttraffic.model.IntersectionReading;
import com.smarttraffic.model.TrafficPrediction;
import org.springframework.stereotype.Service;

@Service
public class TrafficPredictionService {

    public TrafficPrediction predict(IntersectionReading reading, int horizonMinutes) {
        int current = reading.totalVehicles();

        double growthFactor = 1.0 + Math.min(horizonMinutes, 60) / 120.0;
        int predicted = (int) Math.round(current * growthFactor);

        String confidence = horizonMinutes <= 15 ? "high" : horizonMinutes <= 30 ? "medium" : "low";

        return new TrafficPrediction(reading.intersectionId(), current, predicted, horizonMinutes, confidence);
    }
}
