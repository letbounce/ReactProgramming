package ua.com.reactive.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/home")
    public Mono<String> home() {
        return Mono.just("OK");
    }
}


