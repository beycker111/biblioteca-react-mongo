package com.biblotecareact.biblotecareactmongo.routers;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseListAreasTheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultAreaThemeRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllAreaTheme(UseCaseListAreasTheme useCaseListAreasTheme){
        return route(GET("/biblioteca/area/consult").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListAreasTheme.get(), ResourceAreaThemeDTO.class)));
    }
}
