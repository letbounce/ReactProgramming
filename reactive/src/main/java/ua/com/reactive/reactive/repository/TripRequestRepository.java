package ua.com.reactive.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.entity.TripRequest;

public interface TripRequestRepository extends ReactiveCrudRepository<TripRequest, Long> {
}


