package com.smarttraffic.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record SignalPlanRequest(
        @NotBlank String intersectionId,
        @Min(0) int vehiclesNorthSouth,
        @Min(0) int vehiclesEastWest
) {
}
