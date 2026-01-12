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

    // GET-REQUEST / READ
    // findAll method for all genres in a genre list
    public List<GenreResponseDto> findAllGenres() {
        List<GenreEntity> genres = genreRepository.findAll();
        return genreDtoMapper.mapToDto(genres);
    }

    // findById method to find one specific genre
    public GenreResponseDto findGenreById(Long id) {
        Optional<GenreEntity> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isEmpty()) {
            throw new EntityNotFoundException("Genre not found");
        }

        GenreEntity genreEntity = optionalGenre.get();
        return genreDtoMapper.mapToDto(genreEntity);
    }


    // POST-REQUEST / CREATE
    // create method to create a new genre
    @Transactional
    public GenreResponseDto createGenre(GenreRequestDto genreRequestDto) {

        // met null-check
        if (genreRequestDto == null) {
            throw new IllegalArgumentException("GenreRequestDto mag niet null zijn");
        }

        GenreEntity genreEntity = genreDtoMapper.mapToEntity(genreRequestDto);
        GenreEntity savedGenreEntity = genreRepository.save(genreEntity);
        return genreDtoMapper.mapToDto(savedGenreEntity);
    }

    // PUT-REQUEST / UPDATE
    // update method to change one specific genre
    @Transactional
    public GenreResponseDto updateGenre(Long id, GenreRequestDto genreRequestDto) {

        if (genreRequestDto == null) {
            throw new IllegalArgumentException("GenreRequestDto mag niet null zijn");
        }

        Optional<GenreEntity> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isEmpty()) {
            throw new EntityNotFoundException("Genre not found");
        }

        GenreEntity existingGenre = optionalGenre.get();
        existingGenre.setName(genreRequestDto.getName());
        existingGenre.setDescription(genreRequestDto.getDescription());

        GenreEntity updatedGenre = genreRepository.save(existingGenre);
        return genreDtoMapper.mapToDto(updatedGenre);
    }

    // DELETE-REQUEST / DELETE
    // delete method to delete one specific genre
    @Transactional
    public void deleteGenre(Long id) {

        Optional<GenreEntity> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isEmpty()) {
            throw new EntityNotFoundException("Genre not found");
        }

        genreRepository.delete(optionalGenre.get());
    }

}