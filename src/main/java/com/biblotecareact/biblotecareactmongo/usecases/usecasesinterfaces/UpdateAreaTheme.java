package com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdateAreaTheme {
    public Mono<ResourceAreaThemeDTO> apply(ResourceAreaThemeDTO resourceAreaThemeDTO);
}
