package ua.com.reactive.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.entity.Driver;

public interface DriverRepository extends ReactiveCrudRepository<Driver, Long> {
}


