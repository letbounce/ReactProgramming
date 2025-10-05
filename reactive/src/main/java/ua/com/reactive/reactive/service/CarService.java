package ua.com.reactive.reactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Car;
import ua.com.reactive.reactive.repository.CarRepository;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Flux<Car> findAll() { return carRepository.findAll(); }
    public Mono<Car> findById(Long id) { return carRepository.findById(id); }
    public Mono<Car> create(Car car) { return carRepository.save(car); }
    public Mono<Car> update(Long id, Car car) {
        car.setId(id);
        return carRepository.save(car);
    }
    public Mono<Void> delete(Long id) { return carRepository.deleteById(id); }
}


