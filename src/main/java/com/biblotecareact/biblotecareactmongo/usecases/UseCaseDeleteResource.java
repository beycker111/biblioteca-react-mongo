package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.mappers.ResourceMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceRepository;
import com.biblotecareact.biblotecareactmongo.usecases.usecasesinterfaces.DeleteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseDeleteResource implements DeleteResource {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public UseCaseDeleteResource(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<Void> deleteFindById(String id) {
        return resourceRepository.deleteById(id);
    }
}