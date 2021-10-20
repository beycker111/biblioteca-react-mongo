package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import com.biblotecareact.biblotecareactmongo.mappers.ResourceAreaThemeMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceAreaThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class UseCaseListAreasTheme implements Supplier<Flux<ResourceAreaThemeDTO>> {
    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    @Autowired
    public UseCaseListAreasTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Flux<ResourceAreaThemeDTO> get() {
        return resourceAreaThemeRepository.findAll().map(resourceAreaThemeMapper.mappAreaThemeToDTO());
    }
}
