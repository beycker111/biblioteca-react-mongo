package com.biblotecareact.biblotecareactmongo.routers;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import com.biblotecareact.biblotecareactmongo.usecases.UseCaseListAreaThemeById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultAreaThemeByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> consultAreaThemeById(UseCaseListAreaThemeById useCaseListAreaThemeById){
        return route(GET("/biblioteca/area/consult/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                        .body(useCaseListAreaThemeById.apply(request.pathVariable("id")), ResourceAreaThemeDTO.class));
    }
}
