package ua.com.reactive.reactive.entity;

public class Driver {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String licenseNumber;
    private final Long assignedCarId; // references Car.id

    public Driver(Long id, String firstName, String lastName, String licenseNumber, Long assignedCarId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.assignedCarId = assignedCarId;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Long getAssignedCarId() {
        return assignedCarId;
    }
}

