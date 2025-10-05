package ua.com.reactive.reactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("cars")
public class Car {
    @Id
    private Long id;

    private String make;
    private String model;

    @Column("registration_number")
    private String registrationNumber;

    @Column("vehicle_type")
    private VehicleType vehicleType;

    @Column("capacity_kg")
    private int capacityKg;

    private boolean serviceable; // true if the car is in working condition
}

