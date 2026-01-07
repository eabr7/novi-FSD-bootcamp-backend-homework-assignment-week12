package nl.novi.dtoopdracht.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import nl.novi.dtoopdracht.entities.PublisherEntity;
import nl.novi.dtoopdracht.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PublisherService {

    // variables
    private final PublisherRepository publisherRepository;

    // constructor
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    // findAll method for all publishers in a publisher list
    public List<PublisherEntity> findAllPublishers() {
        return publisherRepository.findAll();
    }

    // findById method to find one specific publisher
    public PublisherEntity findPublisherById(Long id) {
        Optional<PublisherEntity> optionalPublisher = publisherRepository.findById(id);
        if  (optionalPublisher.isPresent()) {
            return optionalPublisher.get();
        } else {
            throw new EntityNotFoundException("Publisher not found");
        }
    }

    // create method to create a new publisher
    @Transactional
    public PublisherEntity createPublisher (PublisherEntity input) {
        return publisherRepository.save(input);
    }

    // update method to change one specific publisher
    @Transactional
    public PublisherEntity updatePublisher (long id, PublisherEntity input) {
        PublisherEntity updatedPublisher = findPublisherById(id);
        if  (updatedPublisher != null) {
            updatedPublisher.setName(input.getName());
            updatedPublisher.setAddress(input.getAddress());
            updatedPublisher.setContactDetails(input.getContactDetails());
            return  publisherRepository.save(updatedPublisher);
        } else {
            throw new EntityNotFoundException("Publisher not found");
        }
    }

    // delete method to delete one specific publisher
    @Transactional
    public void deletePublisher (long id) {
        publisherRepository.deleteById(id);
    }

}