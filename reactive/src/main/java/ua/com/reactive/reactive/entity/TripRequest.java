package ua.com.reactive.reactive.entity;

import java.time.LocalDateTime;

public class TripRequest {
    private final Long id;
    private final VehicleType requiredVehicleType;
    private final int requiredCapacityKg;
    private final String route; // simple description
    private final LocalDateTime requestedAt;
    private final RequestStatus status;

    public TripRequest(Long id, VehicleType requiredVehicleType, int requiredCapacityKg,
                       String route, LocalDateTime requestedAt, RequestStatus status) {
        this.id = id;
        this.requiredVehicleType = requiredVehicleType;
        this.requiredCapacityKg = requiredCapacityKg;
        this.route = route;
        this.requestedAt = requestedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public VehicleType getRequiredVehicleType() {
        return requiredVehicleType;
    }

    public int getRequiredCapacityKg() {
        return requiredCapacityKg;
    }

    public String getRoute() {
        return route;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public RequestStatus getStatus() {
        return status;
    }
}

