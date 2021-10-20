package com.biblotecareact.biblotecareactmongo.routers;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseDeleteResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteResourceRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteFindById(UseCaseDeleteResource useCaseDeleteResource){
        return route(DELETE("/biblioteca/resource/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                        .body(useCaseDeleteResource.deleteFindById(request.pathVariable("id")), ResourceDTO.class) );
    }
}