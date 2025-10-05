package ua.com.reactive.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Driver;
import ua.com.reactive.reactive.service.DriverService;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping
    public Flux<Driver> list() { return driverService.findAll(); }

    @GetMapping("/{id}")
    public Mono<Driver> get(@PathVariable Long id) { return driverService.findById(id); }

    @PostMapping
    public Mono<Driver> create(@RequestBody Driver driver) { return driverService.create(driver); }

    @PutMapping("/{id}")
    public Mono<Driver> update(@PathVariable Long id, @RequestBody Driver driver) { return driverService.update(id, driver); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) { return driverService.delete(id); }
}


