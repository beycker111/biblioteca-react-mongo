package com.biblotecareact.biblotecareactmongo.usecases;


import com.biblotecareact.biblotecareactmongo.dtos.ResourceAnswerDTO;
import com.biblotecareact.biblotecareactmongo.mappers.AnswerMapper;
import com.biblotecareact.biblotecareactmongo.repositories.ResourceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class UseCaseConsultAvailabilityResource implements Function<String, Mono<ResourceAnswerDTO>> {
    private final ResourceRepository resourceRepository;
    private final AnswerMapper answerMapper;

    public UseCaseConsultAvailabilityResource(ResourceRepository resourceRepository, AnswerMapper answerMapper) {
        this.resourceRepository = resourceRepository;
        this.answerMapper = answerMapper;
    }

    @Override
    public Mono<ResourceAnswerDTO> apply(String id){
        return resourceRepository.findById(id).map(answerMapper.mappToResource());
    }
}
