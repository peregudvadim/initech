package by.peregud.initech.llc.mapper;

import by.peregud.initech.llc.dto.EmployeeCreateDto;
import by.peregud.initech.llc.dto.EmployeeDto;
import by.peregud.initech.llc.entity.EmployeeEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeeMapper extends BaseMapper<EmployeeCreateDto,EmployeeDto,EmployeeEntity>{


}

