package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.InvoiceCreateDto;
import by.peregud.initech.llc.dto.InvoiceDto;
import by.peregud.initech.llc.entity.InvoiceEntity;
import by.peregud.initech.llc.mapper.InvoiceMapper;
import by.peregud.initech.llc.repository.InvoiceRepository;
import by.peregud.initech.llc.service.InvoiceService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "application")
public class InvoiceServiceImpl extends BaseServiceImpl<InvoiceCreateDto, InvoiceDto,InvoiceEntity> implements InvoiceService {

    private final InvoiceRepository repository;
    private final InvoiceMapper mapper;

    public InvoiceServiceImpl(InvoiceRepository repository,InvoiceMapper mapper) {
        super(repository,mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    protected String getDefaultSortField(){
        return INVOICE_DATE;
    }

    protected Sort.Direction getDefaultSortDirection(){
        return Sort.Direction.DESC;
    }

}
