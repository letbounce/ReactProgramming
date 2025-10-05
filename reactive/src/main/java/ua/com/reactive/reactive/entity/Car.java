package ua.com.reactive.reactive.entity;

public class Car {
    private final Long id;
    private final String make;
    private final String model;
    private final String registrationNumber;
    private final VehicleType vehicleType;
    private final int capacityKg;
    private final boolean serviceable; // true if the car is in working condition

    public Car(Long id, String make, String model, String registrationNumber,
               VehicleType vehicleType, int capacityKg, boolean serviceable) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.capacityKg = capacityKg;
        this.serviceable = serviceable;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getCapacityKg() {
        return capacityKg;
    }

    public boolean isServiceable() {
        return serviceable;
    }
}

