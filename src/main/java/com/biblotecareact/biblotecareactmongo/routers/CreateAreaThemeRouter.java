package com.biblotecareact.biblotecareactmongo.routers;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseCreateAreaTheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateAreaThemeRouter {

    @Bean
    public RouterFunction<ServerResponse> createAreaTheme(UseCaseCreateAreaTheme useCaseCreateAreaTheme){
        return route(POST("/biblioteca/area/create").and(accept(MediaType.APPLICATION_JSON)),
                request ->request.bodyToMono(ResourceAreaThemeDTO.class)
                        .flatMap(areaThemeDTO -> useCaseCreateAreaTheme.apply(areaThemeDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
