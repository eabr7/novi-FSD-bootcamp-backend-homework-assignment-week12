package nl.novi.dtoopdracht.controllers;

import nl.novi.dtoopdracht.helpers.UrlHelper;
import nl.novi.dtoopdracht.entities.GenreEntity;
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
    public ResponseEntity<List<GenreEntity>> getAllGenres() {
        List<GenreEntity> genres = genreService.findAllGenres();
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> getGenreById(@PathVariable Long id) {
        GenreEntity genre = genreService.findGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<GenreEntity> createGenre(@RequestBody GenreEntity genreInput) {
        GenreEntity newGenre = genreService.createGenre(genreInput);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newGenre.getId())).body(newGenre);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<GenreEntity> updateGenre(@PathVariable Long id, @RequestBody GenreEntity genreInput) {
        GenreEntity updatedGenre = genreService.updateGenre(id, genreInput);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}