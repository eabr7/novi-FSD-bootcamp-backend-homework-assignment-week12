package nl.novi.dtoopdracht.mappers;
import nl.novi.dtoopdracht.entities.BaseEntity;
import java.util.List;

// algemene interface voor de mappers
public interface DtoMapper<RESPONSE, REQUEST , T extends BaseEntity> {

    // gaat over de RESPONSE
    RESPONSE mapToDto(T model);
    List<RESPONSE> mapToDto(List<T> models);

    // gaat over de REQUEST
    T mapToEntity(REQUEST model);
}