package com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateResource {
    public Mono<ResourceDTO> apply(ResourceDTO resourceDTO);
}
