package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.ContractCreateDto;
import by.peregud.initech.llc.dto.ContractDto;
import by.peregud.initech.llc.entity.ContractEntity;
import by.peregud.initech.llc.mapper.ContractMapper;
import by.peregud.initech.llc.repository.ContractRepository;
import by.peregud.initech.llc.service.ContractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "application")
@Service
public class ContractServiceImpl extends BaseServiceImpl<ContractCreateDto, ContractDto,ContractEntity> implements ContractService {

    private final ContractRepository repository;
    private final ContractMapper mapper;

    public ContractServiceImpl(ContractRepository repository,ContractMapper mapper) {
        super(repository,mapper);
        this.repository = repository;
        this.mapper=mapper;
    }

    protected String getDefaultSortField(){
        return CONTRACT_NUMBER;
    }
    protected Sort.Direction getDefaultSortDirection(){
        return Sort.Direction.ASC;
    }
}
