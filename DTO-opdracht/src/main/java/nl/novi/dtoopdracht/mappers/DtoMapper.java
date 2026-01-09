package nl.novi.dtoopdracht.mappers;
import nl.novi.dtoopdracht.entities.BaseEntity;

import java.util.List;

public interface DtoMapper<RESPONSE, REQUEST , T extends BaseEntity> {
    RESPONSE mapToDto(T model);

    List<RESPONSE> mapToDto(List<T> models);

    T mapToEntity(REQUEST model);
}