package nl.novi.dtoopdracht.controllers;
import jakarta.validation.Valid;
import nl.novi.dtoopdracht.dtos.genreDto.GenreRequestDto;
import nl.novi.dtoopdracht.dtos.genreDto.GenreResponseDto;
import nl.novi.dtoopdracht.helpers.UrlHelper;
import nl.novi.dtoopdracht.services.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/genres")
public class GenreController {

    // variables
    private final GenreService genreService;
    private final UrlHelper urlHelper;

    // constructor
    public GenreController(GenreService genreService, UrlHelper urlHelper) {
        this.genreService = genreService;
        this.urlHelper = urlHelper;

    }

    // GET
    @GetMapping
    public ResponseEntity<List<GenreResponseDto>> getAllGenres() {
        List<GenreResponseDto> genres = genreService.findAllGenres();
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDto> getGenreById(@PathVariable Long id) {
        GenreResponseDto genre = genreService.findGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<GenreResponseDto> createGenre(@RequestBody @Valid GenreRequestDto genre) {
        GenreResponseDto newGenre = genreService.createGenre(genre);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newGenre.getId())).body(newGenre);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> updateGenre(@PathVariable Long id, @RequestBody @Valid GenreRequestDto genre) {
        GenreResponseDto updatedGenre = genreService.updateGenre(id, genre);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}