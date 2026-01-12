package nl.novi.dtoopdracht.services;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import nl.novi.dtoopdracht.dtos.publisherDto.PublisherRequestDto;
import nl.novi.dtoopdracht.dtos.publisherDto.PublisherResponseDto;
import nl.novi.dtoopdracht.mappers.PublisherDtoMapper;
import nl.novi.dtoopdracht.entities.PublisherEntity;
import nl.novi.dtoopdracht.repositories.PublisherRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PublisherService {

    // variables
    private final PublisherRepository publisherRepository;
    private final PublisherDtoMapper publisherDtoMapper;

    // constructor
    public PublisherService(PublisherRepository publisherRepository, PublisherDtoMapper publisherDtoMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherDtoMapper = publisherDtoMapper;
    }

    // GET-REQUEST / READ
    // findAll method for all publishers in a publisher list
    public List<PublisherResponseDto> findAllPublishers() {
       List<PublisherEntity> publishers = publisherRepository.findAll();
       return publisherDtoMapper.mapToDto(publishers);
    }

    // findById method to find one specific publisher
    public PublisherResponseDto findPublisherById(Long id) {
        Optional<PublisherEntity> optionalPublisher = publisherRepository.findById(id);

        if (optionalPublisher.isEmpty()) {
            throw new EntityNotFoundException("Publisher not found");
        }

        PublisherEntity publisherEntity = optionalPublisher.get();
        return  publisherDtoMapper.mapToDto(publisherEntity);
    }

    // POST-REQUEST / CREATE
    // create method to create a new publisher
    @Transactional
    public PublisherResponseDto createPublisher (PublisherRequestDto publisherRequestDto) {

        // met null-check
        if (publisherRequestDto == null) {
            throw new IllegalArgumentException("PublisherRequestDto mag niet null zijn");
        }

        PublisherEntity publisherEntity = publisherDtoMapper.mapToEntity(publisherRequestDto);
        PublisherEntity savedPublisherEntity = publisherRepository.save(publisherEntity);
        return publisherDtoMapper.mapToDto(savedPublisherEntity);
    }

    // PUT-REQUEST / UPDATE
    // update method to change one specific publisher
    @Transactional
    public PublisherResponseDto updatePublisher (Long id, PublisherRequestDto publisherRequestDto) {

       if (publisherRequestDto == null) {
            throw new IllegalArgumentException("PublisherRequestDto mag niet null zijn");
        }

        Optional<PublisherEntity> optionalPublisher = publisherRepository.findById(id);

        if (optionalPublisher.isEmpty()) {
            throw new EntityNotFoundException("Publisher not found");
        }

        PublisherEntity existingPublisher = optionalPublisher.get();
        existingPublisher.setName(publisherRequestDto.getName());

        PublisherEntity updatedPublisher = publisherRepository.save(existingPublisher);
        return publisherDtoMapper.mapToDto(updatedPublisher);
    }

    // DELETE-REQUEST / DELETE
    // delete method to delete one specific publisher
    @Transactional
    public void deletePublisher(Long id) {

        Optional<PublisherEntity> optionalPublisher = publisherRepository.findById(id);

        if (optionalPublisher.isEmpty()) {
            throw new EntityNotFoundException("Publisher not found");
        }

        publisherRepository.delete(optionalPublisher.get());
    }

}