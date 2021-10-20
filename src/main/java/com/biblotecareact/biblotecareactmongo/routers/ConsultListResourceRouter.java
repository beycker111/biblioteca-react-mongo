package com.biblotecareact.biblotecareactmongo.routers;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseListResources;
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
public class ConsultListResourceRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllResources(UseCaseListResources useCaseListResource){
        return route(GET("/biblioteca/resource/consult").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListResource.get(), ResourceDTO.class))
        );
    }
}
