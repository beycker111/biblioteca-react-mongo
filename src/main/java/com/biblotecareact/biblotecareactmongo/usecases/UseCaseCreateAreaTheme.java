package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import com.biblotecareact.biblotecareactmongo.mappers.ResourceAreaThemeMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceAreaThemeRepository;
import com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces.CreateAreaTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateAreaTheme implements CreateAreaTheme {

    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    @Autowired

    public UseCaseCreateAreaTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Mono<ResourceAreaThemeDTO> apply(ResourceAreaThemeDTO resourceAreaThemeDTO) {
        var areaTheme = resourceAreaThemeRepository.save(resourceAreaThemeMapper.mapperToAreaTheme(null).apply(resourceAreaThemeDTO)).map(resourceAreaThemeMapper.mappAreaThemeToDTO());
        return areaTheme;
    }
}
