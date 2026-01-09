package nl.novi.dtoopdracht.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import nl.novi.dtoopdracht.dtos.genreDto.GenreRequestDto;
import nl.novi.dtoopdracht.dtos.genreDto.GenreResponseDto;
import nl.novi.dtoopdracht.mappers.GenreDtoMapper;
import nl.novi.dtoopdracht.entities.GenreEntity;
import nl.novi.dtoopdracht.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GenreService {

    // variables
    private final GenreRepository genreRepository;
    private final GenreDtoMapper genreDtoMapper;

    // constructor
    public GenreService(GenreRepository genreRepository, GenreDtoMapper genreDtoMapper) {
        this.genreRepository = genreRepository;
        this.genreDtoMapper = genreDtoMapper;
    }

    // findAll method for all genres in a genre list
    public List<GenreEntity> findAllGenres() {
        return genreRepository.findAll();
    }

    // findById method to find one specific genre
    public GenreEntity findGenreById(Long id) {
        Optional<GenreEntity> optionalGenre = genreRepository.findById(id);
        if  (optionalGenre.isPresent()) {
            return optionalGenre.get();
        } else {
            throw new EntityNotFoundException("Genre not found");
        }
    }

    // create method to create a new genre
    @Transactional
    public GenreResponseDto createGenre(GenreRequestDto genreDto) {

        // met null-check
        if (genreDto == null) {
            throw new IllegalArgumentException("GenreRequestDto mag niet null zijn");
        }

        GenreEntity genreEntity = genreDtoMapper.mapToEntity(genreDto);
        genreEntity = genreRepository.save(genreEntity);
        return genreDtoMapper.mapToDto(genreEntity);
    }


    // update method to change one specific genre
    @Transactional
    public GenreEntity updateGenre (long id, GenreEntity input) {
        GenreEntity updatedGenre = findGenreById(id);
        if  (updatedGenre != null) {
            updatedGenre.setName(input.getName());
            updatedGenre.setDescription(input.getDescription());
            return  genreRepository.save(updatedGenre);
        } else {
            throw new EntityNotFoundException("Genre not found");
        }
    }

    // delete method to delete one specific genre
    @Transactional
    public void deleteGenre (long id) {
        genreRepository.deleteById(id);
    }

}