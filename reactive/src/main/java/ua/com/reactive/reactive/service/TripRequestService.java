package ua.com.reactive.reactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.TripRequest;
import ua.com.reactive.reactive.repository.TripRequestRepository;

@Service
@RequiredArgsConstructor
public class TripRequestService {
    private final TripRequestRepository tripRequestRepository;

    public Flux<TripRequest> findAll() { return tripRequestRepository.findAll(); }
    public Mono<TripRequest> findById(Long id) { return tripRequestRepository.findById(id); }
    public Mono<TripRequest> create(TripRequest tripRequest) { return tripRequestRepository.save(tripRequest); }
    public Mono<TripRequest> update(Long id, TripRequest tripRequest) {
        tripRequest.setId(id);
        return tripRequestRepository.save(tripRequest);
    }
    public Mono<Void> delete(Long id) { return tripRequestRepository.deleteById(id); }
}


