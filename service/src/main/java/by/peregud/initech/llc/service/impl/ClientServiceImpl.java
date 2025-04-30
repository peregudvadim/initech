package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.ClientCreateDto;
import by.peregud.initech.llc.dto.ClientDto;
import by.peregud.initech.llc.entity.ClientEntity;
import by.peregud.initech.llc.mapper.ClientMapper;
import by.peregud.initech.llc.repository.ClientRepository;
import by.peregud.initech.llc.service.ClientService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@CacheConfig(cacheNames = "application")
public class ClientServiceImpl extends BaseServiceImpl<ClientCreateDto, ClientDto,ClientEntity> implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository,ClientMapper mapper) {
        super(repository,mapper);
        this.repository = repository;
        this.mapper=mapper;
    }

    protected String getDefaultSortField(){
        return CLIENT_NAME;
    }
    protected Sort.Direction getDefaultSortDirection(){
        return Sort.Direction.ASC;
    }

}

