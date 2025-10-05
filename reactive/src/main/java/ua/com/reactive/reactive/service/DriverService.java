package ua.com.reactive.reactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Driver;
import ua.com.reactive.reactive.repository.DriverRepository;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Flux<Driver> findAll() { return driverRepository.findAll(); }
    public Mono<Driver> findById(Long id) { return driverRepository.findById(id); }
    public Mono<Driver> create(Driver driver) { return driverRepository.save(driver); }
    public Mono<Driver> update(Long id, Driver driver) {
        driver.setId(id);
        return driverRepository.save(driver);
    }
    public Mono<Void> delete(Long id) { return driverRepository.deleteById(id); }
}


