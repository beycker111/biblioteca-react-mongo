package com.biblotecareact.biblotecareactmongo.repositories;

import com.biblotecareact.biblotecareactmongo.collections.ResourceAreaTheme;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ResourceAreaThemeRepository extends ReactiveMongoRepository<ResourceAreaTheme, String> {
}
