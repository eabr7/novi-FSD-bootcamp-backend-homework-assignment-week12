package nl.novi.dtoopdracht.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import nl.novi.dtoopdracht.entities.GenreEntity;
import nl.novi.dtoopdracht.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GenreService {

    // variables
    private final GenreRepository genreRepository;

    // constructor
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
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
    public GenreEntity createGenre (GenreEntity input) {
        return genreRepository.save(input);
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