package com.smarttraffic.service;

import com.smarttraffic.model.SignalPlanRequest;
import com.smarttraffic.model.SignalPlanResponse;
import org.springframework.stereotype.Service;

@Service
public class SignalOptimizationService {

    private static final int CYCLE_SECONDS = 90;

    public SignalPlanResponse optimize(SignalPlanRequest request) {
        int total = Math.max(1, request.vehiclesNorthSouth() + request.vehiclesEastWest());

        int northSouth = (int) Math.round((double) request.vehiclesNorthSouth() / total * CYCLE_SECONDS);
        int eastWest = CYCLE_SECONDS - northSouth;

        northSouth = clamp(northSouth, 20, 70);
        eastWest = CYCLE_SECONDS - northSouth;

        return new SignalPlanResponse(
                request.intersectionId(),
                northSouth,
                eastWest,
                "Adaptive ratio-based split"
        );
    }

    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
