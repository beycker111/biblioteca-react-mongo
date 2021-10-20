package com.biblotecareact.biblotecareactmongo.usecases;

import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.mappers.ResourceMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceRepository;
import com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces.CreateResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateResource implements CreateResource {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public UseCaseCreateResource(ResourceMapper resourceMapper, ResourceRepository resourceRepository) {
        this.resourceMapper = resourceMapper;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Mono<ResourceDTO> apply(ResourceDTO resourceDTO) {
        var resource = resourceRepository.save(resourceMapper.mapperToResource(null).apply(resourceDTO)).map(resourceMapper.mappResourceToDTO());
        return resource;
    }
}
