package com.biblotecareact.biblotecareactmongo.routers;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseRecommendResourceType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RecommendResourceTypeRouter {

    @Bean
    public RouterFunction<ServerResponse> recommendResourceType(UseCaseRecommendResourceType useCaseRecommendResourceType){
        return route(GET("/biblioteca/resource/recommend/type/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .body(useCaseRecommendResourceType.apply(request.pathVariable("id")), ResourceDTO.class));
    }
}
