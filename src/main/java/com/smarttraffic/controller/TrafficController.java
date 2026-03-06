package com.smarttraffic.controller;

import com.smarttraffic.model.IntersectionReading;
import com.smarttraffic.model.SignalPlanRequest;
import com.smarttraffic.model.SignalPlanResponse;
import com.smarttraffic.model.TrafficPrediction;
import com.smarttraffic.service.SignalOptimizationService;
import com.smarttraffic.service.TrafficPredictionService;
import com.smarttraffic.service.TrafficSimulationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrafficController {

    private final TrafficSimulationService simulationService;
    private final SignalOptimizationService optimizationService;
    private final TrafficPredictionService predictionService;

    public TrafficController(TrafficSimulationService simulationService,
                             SignalOptimizationService optimizationService,
                             TrafficPredictionService predictionService) {
        this.simulationService = simulationService;
        this.optimizationService = optimizationService;
        this.predictionService = predictionService;
    }

    @GetMapping("/api/traffic/realtime")
    public List<IntersectionReading> realtime() {
        return simulationService.currentReadings();
    }

    @PostMapping("/api/traffic/optimize")
    public SignalPlanResponse optimize(@Valid @RequestBody SignalPlanRequest request) {
        return optimizationService.optimize(request);
    }

    @GetMapping("/api/traffic/predict")
    public List<TrafficPrediction> predict(@RequestParam(defaultValue = "15") int minutes) {
        return simulationService.currentReadings().stream()
                .map(reading -> predictionService.predict(reading, minutes))
                .toList();
    }
}
