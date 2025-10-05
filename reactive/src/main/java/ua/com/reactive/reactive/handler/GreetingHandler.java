package ua.com.reactive.reactive.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Client;
import ua.com.reactive.reactive.entity.User;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("Hello World!"));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Main page!"));
    }

    public Mono<ServerResponse> getClients(ServerRequest request) {

        String start = request
                .queryParam("start")
                .orElse("0");
        long startIndex;
        try {
            startIndex = Long.parseLong(start);
        } catch (NumberFormatException ex) {
            startIndex = 0L;
        }


        Flux<Client> clients = Flux.just(
                        new Client(1L, "Vasya", "Pypkin", 18),
                        new Client(2L, "Iva", "Pypkina", 19),
                        new Client(3L, "Inna", "Pypkina", 20)
                )
                .skip(startIndex)
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Client.class);
    }

    public Mono<ServerResponse> users(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("User Page"));
    }

    public Mono<ServerResponse> admin(ServerRequest request) {

        Flux<User> users = Flux.
                just(
                        new User(1L, "Vasya", "1234"),
                        new User(2L, "Inna", "1234"),
                        new User(3L, "Ira", "1234")
                );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(users, User.class);
    }

}