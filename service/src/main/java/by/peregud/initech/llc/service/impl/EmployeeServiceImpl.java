package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.EmployeeCreateDto;
import by.peregud.initech.llc.dto.EmployeeDto;
import by.peregud.initech.llc.dto.SearchDto;
import by.peregud.initech.llc.entity.EmployeeEntity;
import by.peregud.initech.llc.mapper.EmployeeMapper;
import by.peregud.initech.llc.repository.EmployeeRepository;
import by.peregud.initech.llc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@CacheConfig(cacheNames = "application")
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeCreateDto,EmployeeDto,EmployeeEntity> implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }


    protected String getDefaultSortField(){
        return LAST_NAME;
    }


    @Override
    public List<EmployeeDto> searchByData(SearchDto searchDto,int page) {

        Pageable pageable = PageRequest.of(page-1,PAGE_SIZE);
        Page<EmployeeEntity> employeeEntityPage = repository.searchByData(searchDto.getData(),pageable);

        return employeeEntityPage.getContent().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}







