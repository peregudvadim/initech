package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.TransactionCreateDto;
import by.peregud.initech.llc.dto.TransactionDto;
import by.peregud.initech.llc.entity.TransactionEntity;
import by.peregud.initech.llc.mapper.TransactionMapper;
import by.peregud.initech.llc.repository.TransactionRepository;
import by.peregud.initech.llc.service.TransactionService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "application")
public class TransactionServiceImpl extends BaseServiceImpl<TransactionCreateDto, TransactionDto, TransactionEntity> implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    public TransactionServiceImpl(TransactionRepository repository, TransactionMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected String getDefaultSortField() {
        return TRANSACTION_DATE;
    }

    @Override
    protected Sort.Direction getDefaultSortDirection() {
        return Sort.Direction.DESC;
    }
}
