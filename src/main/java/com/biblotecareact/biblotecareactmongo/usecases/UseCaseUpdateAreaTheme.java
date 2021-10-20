package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import com.biblotecareact.biblotecareactmongo.mappers.ResourceAreaThemeMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceAreaThemeRepository;
import com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces.UpdateAreaTheme;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseUpdateAreaTheme implements UpdateAreaTheme {
    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    public UseCaseUpdateAreaTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Mono<ResourceAreaThemeDTO> apply(ResourceAreaThemeDTO resourceAreaThemeDTO){
        return resourceAreaThemeRepository.save(resourceAreaThemeMapper.mapperToAreaTheme(resourceAreaThemeDTO.getId()).apply(resourceAreaThemeDTO)).map(resourceAreaThemeMapper.mappAreaThemeToDTO());
    }
}
