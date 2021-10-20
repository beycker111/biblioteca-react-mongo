package com.biblotecareact.biblotecareactmongo.mappers;

import com.biblotecareact.biblotecareactmongo.collections.ResourceAreaTheme;
import com.biblotecareact.biblotecareactmongo.dtos.ResourceAreaThemeDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ResourceAreaThemeMapper {
    public Function<ResourceAreaThemeDTO, ResourceAreaTheme> mapperToAreaTheme(String id){
        return updateAreaTheme ->{
            var areaTheme = new ResourceAreaTheme();
            areaTheme.setId(id);
            areaTheme.setName(updateAreaTheme.getName());

            return areaTheme;
        };
    }

    public Function<ResourceAreaTheme, ResourceAreaThemeDTO> mappAreaThemeToDTO(){
        return entity ->new ResourceAreaThemeDTO(entity.getId(),entity.getName());
    }
}
