package com.biblotecareact.biblotecareactmongo.mappers;

import com.biblotecareact.biblotecareactmongo.collections.Resource;
import com.biblotecareact.biblotecareactmongo.dtos.ResourceDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ResourceMapper {

    public Function<ResourceDTO, Resource> mapperToResource(String id) {
        return updateResource -> {
            var resource = new Resource();
            resource.setId(id);
            resource.setAreaThemeId(updateResource.getAreaThemeId());
            resource.setResourceType(updateResource.getResourceType());
            resource.setStatus(updateResource.getStatus());
            resource.setName(updateResource.getName());
            resource.setDate(updateResource.getDate());
            resource.setDate(updateResource.getDate());
            return resource;
        };
    }

    public Function<Resource, ResourceDTO> mappResourceToDTO() {
        return entity -> new ResourceDTO(entity.getId(), entity.getAreaThemeId(), entity.getResourceType(), entity.getStatus(), entity.getName(), entity.getDate());
    }
}
