package com.biblotecareact.biblotecareactmongo.routers;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseUpdateResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateResourceRouter {

    @Bean
    public RouterFunction<ServerResponse> updateResource(UseCaseUpdateResource useCaseUpdateResource){
        return route(PUT("/biblioteca/resource/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ResourceDTO.class)
                        .flatMap(recursoDTO -> useCaseUpdateResource.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}