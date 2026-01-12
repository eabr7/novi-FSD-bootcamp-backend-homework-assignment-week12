package nl.novi.dtoopdracht.controllers;
import jakarta.validation.Valid;
import nl.novi.dtoopdracht.helpers.UrlHelper;
import nl.novi.dtoopdracht.dtos.publisherDto.PublisherRequestDto;
import nl.novi.dtoopdracht.dtos.publisherDto.PublisherResponseDto;
import nl.novi.dtoopdracht.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    // variables
    private final PublisherService publisherService;
    private final UrlHelper urlHelper;

    // constructor
    public PublisherController(PublisherService publisherService, UrlHelper urlHelper) {
        this.publisherService = publisherService;
        this.urlHelper = urlHelper;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> getAllPublishers() {
        List<PublisherResponseDto> publishers = publisherService.findAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> getPublisherById(@PathVariable Long id) {
        PublisherResponseDto publisher = publisherService.findPublisherById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<PublisherResponseDto> createPublisher(@RequestBody @Valid PublisherRequestDto publisherInput) {
        PublisherResponseDto newPublisher = publisherService.createPublisher(publisherInput);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newPublisher.getId())).body(newPublisher);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> updatePublisherById(@PathVariable Long id, @RequestBody @Valid PublisherRequestDto publisherInput) {
        PublisherResponseDto updatedPublisher = publisherService.updatePublisher(id, publisherInput);
        return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisherById(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}