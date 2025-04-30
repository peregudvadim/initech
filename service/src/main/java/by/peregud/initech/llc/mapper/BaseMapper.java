package by.peregud.initech.llc.mapper;

import by.peregud.initech.llc.dto.BaseCreateDto;
import by.peregud.initech.llc.dto.BaseDto;
import by.peregud.initech.llc.entity.BaseEntity;
import org.mapstruct.MappingTarget;

public interface BaseMapper <C extends BaseCreateDto,D extends BaseDto,E extends BaseEntity>{



    E toEntity(C createDto);

    D toDto(E entity);

    void updateFromDto(D dto, @MappingTarget E entity);
}
