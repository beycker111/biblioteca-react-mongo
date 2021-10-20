package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import com.biblotecareact.biblotecareactmongo.mappers.AnswerMapper;
import com.biblotecareact.biblotecareactmongo.mappers.ResourceMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@Validated
public class UseCaseLendResource implements Function<String, Mono<ResourceDTO>> {
    private final ResourceRepository resourceRepository;
    private final AnswerMapper answerMapper;
    private final ResourceMapper resourceMapper;

    @Autowired

    public UseCaseLendResource(ResourceRepository resourceRepository, AnswerMapper answerMapper, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.answerMapper = answerMapper;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<ResourceDTO> apply(String id){

        var resp = resourceRepository.findById(id)
                .flatMap(resource -> {
                    LocalDate date=LocalDate.now();
                    if(resource.getStatus()){
                        resource.setStatus(true);
                        resource.setDate(date.toString());
                        return resourceRepository.save(resource);
                    }
                    resource.getStatus();
                    resource.getDate();
                    return resourceRepository.save(resource);
                });

        return null;
    }
}
