package by.peregud.initech.llc.service;

import by.peregud.initech.llc.dto.DepartmentCreateDto;
import by.peregud.initech.llc.dto.DepartmentDto;

public interface DepartmentService extends BaseService<DepartmentCreateDto, DepartmentDto>, PageableService<DepartmentDto> {
}
