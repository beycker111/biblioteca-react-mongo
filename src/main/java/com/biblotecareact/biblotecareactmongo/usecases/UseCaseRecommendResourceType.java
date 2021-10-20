package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.mappers.ResourceMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class UseCaseRecommendResourceType implements Function<String, Flux<ResourceDTO>> {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public UseCaseRecommendResourceType(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Flux<ResourceDTO> apply(String resourceType){
        return resourceRepository.findByResourceType(resourceType).map(resourceMapper.mappResourceToDTO());
    }
}
