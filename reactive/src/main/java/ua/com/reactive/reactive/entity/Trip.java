package ua.com.reactive.reactive.entity;

import java.time.LocalDateTime;

public class Trip {
    private final Long id;
    private final Long requestId; // references TripRequest.id
    private final Long driverId;  // references Driver.id
    private final Long carId;     // references Car.id
    private final LocalDateTime assignedAt;
    private final LocalDateTime startedAt;
    private final LocalDateTime completedAt;
    private final CarConditionNote completionCarCondition; // driver's note on completion

    public Trip(Long id, Long requestId, Long driverId, Long carId,
                LocalDateTime assignedAt, LocalDateTime startedAt,
                LocalDateTime completedAt, CarConditionNote completionCarCondition) {
        this.id = id;
        this.requestId = requestId;
        this.driverId = driverId;
        this.carId = carId;
        this.assignedAt = assignedAt;
        this.startedAt = startedAt;
        this.completedAt = completedAt;
        this.completionCarCondition = completionCarCondition;
    }

    public Long getId() { return id; }
    public Long getRequestId() { return requestId; }
    public Long getDriverId() { return driverId; }
    public Long getCarId() { return carId; }
    public LocalDateTime getAssignedAt() { return assignedAt; }
    public LocalDateTime getStartedAt() { return startedAt; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public CarConditionNote getCompletionCarCondition() { return completionCarCondition; }
}

