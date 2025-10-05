package ua.com.reactive.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.entity.Car;

public interface CarRepository extends ReactiveCrudRepository<Car, Long> {
}


