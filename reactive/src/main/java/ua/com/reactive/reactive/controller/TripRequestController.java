package ua.com.reactive.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.TripRequest;
import ua.com.reactive.reactive.service.TripRequestService;

@RestController
@RequestMapping("/trip-requests")
@RequiredArgsConstructor
public class TripRequestController {
    private final TripRequestService tripRequestService;

    @GetMapping
    public Flux<TripRequest> list() { return tripRequestService.findAll(); }

    @GetMapping("/{id}")
    public Mono<TripRequest> get(@PathVariable Long id) { return tripRequestService.findById(id); }

    @PostMapping
    public Mono<TripRequest> create(@RequestBody TripRequest tripRequest) { return tripRequestService.create(tripRequest); }

    @PutMapping("/{id}")
    public Mono<TripRequest> update(@PathVariable Long id, @RequestBody TripRequest tripRequest) { return tripRequestService.update(id, tripRequest); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) { return tripRequestService.delete(id); }
}


