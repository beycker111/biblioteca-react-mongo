package com.biblotecareact.biblotecareactmongo.routers;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseConsultResourceById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ConsultResourceByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> consultResourceById(UseCaseConsultResourceById useCaseConsultResourceById){
        return route(GET("/biblioteca/resource/consult/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                .body(useCaseConsultResourceById.findById(request.pathVariable("id")), ResourceDTO.class));
    }
}
