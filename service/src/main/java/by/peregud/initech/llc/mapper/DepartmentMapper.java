package by.peregud.initech.llc.mapper;

import by.peregud.initech.llc.dto.DepartmentCreateDto;
import by.peregud.initech.llc.dto.DepartmentDto;
import by.peregud.initech.llc.entity.DepartmentEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DepartmentMapper extends BaseMapper<DepartmentCreateDto, DepartmentDto, DepartmentEntity>{


}
