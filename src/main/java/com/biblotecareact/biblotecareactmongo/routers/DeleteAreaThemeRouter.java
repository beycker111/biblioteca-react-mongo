package com.example.biblioteca.routers;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseDeleteAreaTheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteAreaThemeRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteAreaTheme(UseCaseDeleteAreaTheme useCaseDeleteAreaTheme) {
        return route(DELETE("/biblioteca/area/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                        .body(useCaseDeleteAreaTheme.deleteFindById(request.pathVariable("id")), ResourceAreaThemeDTO.class));
    }
}