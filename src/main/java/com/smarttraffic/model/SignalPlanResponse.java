package com.smarttraffic.model;

public record SignalPlanResponse(
        String intersectionId,
        int greenNorthSouthSeconds,
        int greenEastWestSeconds,
        String strategy
) {
}
