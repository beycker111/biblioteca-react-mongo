package com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteAreaTheme {
    public Mono<Void> deleteFindById(String id);
}
