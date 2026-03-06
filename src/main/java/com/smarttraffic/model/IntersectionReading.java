package com.smarttraffic.model;

public record IntersectionReading(
        String intersectionId,
        int vehiclesNorthSouth,
        int vehiclesEastWest,
        long timestamp
) {
    public int totalVehicles() {
        return vehiclesNorthSouth + vehiclesEastWest;
    }
}
