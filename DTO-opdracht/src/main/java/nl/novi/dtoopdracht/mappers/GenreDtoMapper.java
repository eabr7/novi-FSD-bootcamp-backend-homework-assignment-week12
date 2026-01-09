package nl.novi.dtoopdracht.mappers;
import nl.novi.dtoopdracht.dtos.genreDto.GenreRequestDto;
import nl.novi.dtoopdracht.dtos.genreDto.GenreResponseDto;
import nl.novi.dtoopdracht.entities.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreDtoMapper implements DtoMapper<GenreResponseDto, GenreRequestDto, GenreEntity>  {

    @Override
    public GenreResponseDto mapToDto(GenreEntity genre) {
        if (genre == null) {
            return null;
        }
        GenreResponseDto result = new GenreResponseDto();
        result.setId(genre.getId());
        result.setName(genre.getName());
        result.setDescription(genre.getDescription());
        return result;
    }


    @Override
    public List<GenreResponseDto> mapToDto(List<GenreEntity> genres) {
        List<GenreResponseDto> result = new ArrayList<>();
        for (GenreEntity genre : genres) {
            result.add(mapToDto(genre));
        }
        return result;
    }

    @Override
    public GenreEntity mapToEntity(GenreRequestDto genreRequestDto) {
        GenreEntity entity = new GenreEntity();
        entity.setName(genreRequestDto.getName());
        entity.setDescription(genreRequestDto.getDescription());
        return entity;
    }

}

