package nl.novi.dtoopdracht.mappers;
import nl.novi.dtoopdracht.entities.PublisherEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import nl.novi.dtoopdracht.dtos.publisherDto.PublisherResponseDto;
import nl.novi.dtoopdracht.dtos.publisherDto.PublisherRequestDto;

@Component
public class PublisherDtoMapper implements DtoMapper<PublisherResponseDto, PublisherRequestDto, PublisherEntity> {

    // gaat over de RESPONSE
    @Override
    public PublisherResponseDto mapToDto(PublisherEntity publisher) {
        if (publisher == null) {
            return null;
        }
        PublisherResponseDto result = new PublisherResponseDto();
        result.setId(publisher.getId());
        result.setName(publisher.getName());
        result.setAddress(publisher.getAddress());
        result.setContactDetails(publisher.getContactDetails());
        return result;
    }

    @Override
    public List<PublisherResponseDto> mapToDto(List<PublisherEntity> publishers) {
        List<PublisherResponseDto> result = new ArrayList<>();
        for (PublisherEntity publisher : publishers) {
            result.add(mapToDto(publisher));
        }
        return result;
    }

    // gaat over de REQUEST
    // alleen de velden in de PublisherRequestDto! Niet alle velden van de ResponseDto, anders kan de gebruiker ongeautoriseerde data lezen/wijzigen
    @Override
    public PublisherEntity mapToEntity(PublisherRequestDto publisherRequestDto) {
        PublisherEntity entity = new PublisherEntity();
        entity.setName(publisherRequestDto.getName());
        return entity;
    }

}
