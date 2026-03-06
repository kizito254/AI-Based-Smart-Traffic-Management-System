# AI-Based Smart Traffic Management System

A starter implementation of an intelligent traffic control platform using **Java + Spring Boot** with simulated real-time data.

## Idea

This project demonstrates how machine learning-inspired logic and real-time traffic telemetry can optimize traffic lights and reduce congestion at city intersections.

## Technology Stack

- Java 17
- Spring Boot 3
- REST APIs for traffic data and control decisions
- Simulated IoT sensor streams (replaceable with real sensors)
- Ready to integrate with MySQL/PostgreSQL and TensorFlow/Weka models

## Core Features Implemented

### 1) Real-time Traffic Monitoring

`GET /api/traffic/realtime`

Returns simulated intersection readings (north/south and east/west vehicle counts) representing live sensor data.

### 2) AI-based Signal Optimization

`POST /api/traffic/optimize`

Accepts intersection traffic volumes and returns an adaptive green-light split strategy.

Sample request:

```json
{
  "intersectionId": "A1",
  "vehiclesNorthSouth": 55,
  "vehiclesEastWest": 35
}
```

### 3) Traffic Prediction Dashboard API

`GET /api/traffic/predict?minutes=15`

Generates short-horizon traffic forecasts and confidence levels for each intersection.

## Run Locally

```bash
mvn spring-boot:run
```

Then call endpoints from Postman/curl or connect a UI dashboard.

## Next Steps

- Replace simulated readings with real IoT ingestion (MQTT/Kafka/HTTP).
- Persist historical sensor and signal-plan data in MySQL/PostgreSQL.
- Swap heuristic predictor/optimizer with trained TensorFlow or Weka models.
- Build a front-end dashboard (React/Angular) for operators.
