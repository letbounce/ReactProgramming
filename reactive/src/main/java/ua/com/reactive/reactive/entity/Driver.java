package ua.com.reactive.reactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("drivers")
public class Driver {
    @Id
    private Long id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("license_number")
    private String licenseNumber;

    @Column("assigned_car_id")
    private Long assignedCarId; // references Car.id
}

