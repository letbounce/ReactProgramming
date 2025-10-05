package ua.com.reactive.reactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("trip_requests")
public class TripRequest {
    @Id
    private Long id;

    @Column("required_vehicle_type")
    private VehicleType requiredVehicleType;

    @Column("required_capacity_kg")
    private int requiredCapacityKg;

    private String route; // simple description

    @Column("requested_at")
    private LocalDateTime requestedAt;

    private RequestStatus status;
}

