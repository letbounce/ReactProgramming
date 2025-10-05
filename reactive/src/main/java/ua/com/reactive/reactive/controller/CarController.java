package ua.com.reactive.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Car;
import ua.com.reactive.reactive.service.CarService;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public Flux<Car> list() { return carService.findAll(); }

    @GetMapping("/{id}")
    public Mono<Car> get(@PathVariable Long id) { return carService.findById(id); }

    @PostMapping
    public Mono<Car> create(@RequestBody Car car) { return carService.create(car); }

    @PutMapping("/{id}")
    public Mono<Car> update(@PathVariable Long id, @RequestBody Car car) { return carService.update(id, car); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) { return carService.delete(id); }
}


