package by.peregud.initech.llc.service;

import by.peregud.initech.llc.dto.EmployeeCreateDto;
import by.peregud.initech.llc.dto.EmployeeDto;
import by.peregud.initech.llc.dto.SearchDto;

import java.util.List;

public interface EmployeeService extends BaseService<EmployeeCreateDto,EmployeeDto>, PageableService<EmployeeDto> {


 List<EmployeeDto> searchByData(SearchDto searchDto,int page);
}
