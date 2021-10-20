package com.biblotecareact.biblotecareactmongo.routers;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceAnswerDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseConsultAvailabilityResource;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class ConsultAvailabilityResourceRouter  {

    @Bean
    public RouterFunction<ServerResponse> consultAvailabilityResource(UseCaseConsultAvailabilityResource useCaseConsultAvailabilityResource){
        return route(GET("/biblioteca/resource/availability/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .body(useCaseConsultAvailabilityResource.apply(request.pathVariable("id")), ResourceAnswerDTO.class));
    }
}
