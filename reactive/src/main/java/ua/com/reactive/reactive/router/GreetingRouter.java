package ua.com.reactive.reactive.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
<<<<<<< HEAD
import org.springframework.web.reactive.function.server.RequestPredicate;
=======
>>>>>>> 4122fc677ca14eb0f406f7e5fcc4cb9f0488e336
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ua.com.reactive.reactive.handler.GreetingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
<<<<<<< HEAD
        return RouterFunctions
                .route(RequestPredicates.GET("/"), greetingHandler::hello)
                .andRoute(RequestPredicates.GET("/users"), greetingHandler::users)
                .andRoute(RequestPredicates.GET("/admin"), greetingHandler::admin);
=======

        return RouterFunctions
                .route(RequestPredicates.GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello)
                .andRoute(RequestPredicates.GET("/"), greetingHandler::home)
                .andRoute(RequestPredicates.GET("/users"), greetingHandler::getClients);
>>>>>>> 4122fc677ca14eb0f406f7e5fcc4cb9f0488e336
    }
}