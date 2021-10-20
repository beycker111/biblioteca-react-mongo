package com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdateResource {
    public Mono<ResourceDTO> apply(ResourceDTO resourceDTO);
}
