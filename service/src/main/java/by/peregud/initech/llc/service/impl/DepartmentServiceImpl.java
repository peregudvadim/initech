package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.DepartmentCreateDto;
import by.peregud.initech.llc.dto.DepartmentDto;
import by.peregud.initech.llc.entity.DepartmentEntity;
import by.peregud.initech.llc.mapper.DepartmentMapper;
import by.peregud.initech.llc.repository.DepartmentRepository;
import by.peregud.initech.llc.service.DepartmentService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "application")
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentCreateDto, DepartmentDto,DepartmentEntity> implements DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    public DepartmentServiceImpl(DepartmentRepository repository, DepartmentMapper mapper) {
        super(repository,mapper);
        this.repository = repository;
        this.mapper=mapper;
    }

    protected String getDefaultSortField(){
        return DEPARTMENT;
    }

}
