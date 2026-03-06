package com.smarttraffic.model;

public record TrafficPrediction(
        String intersectionId,
        int currentLoad,
        int predictedLoad,
        int horizonMinutes,
        String confidence
) {
}
