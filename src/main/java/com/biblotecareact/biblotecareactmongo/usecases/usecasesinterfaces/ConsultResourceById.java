package com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ConsultResourceById {
    public Mono<ResourceDTO> findById(String id);
}
