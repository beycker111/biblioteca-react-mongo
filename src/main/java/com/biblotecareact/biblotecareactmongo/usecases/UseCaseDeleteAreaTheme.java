package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.mappers.ResourceAreaThemeMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceAreaThemeRepository;
import com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces.DeleteAreaTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.swing.*;

@Service
public class UseCaseDeleteAreaTheme implements DeleteAreaTheme {
    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    @Autowired
    public UseCaseDeleteAreaTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Mono<Void> deleteFindById(String id){
        return resourceAreaThemeRepository.deleteById(id);
    }
}
