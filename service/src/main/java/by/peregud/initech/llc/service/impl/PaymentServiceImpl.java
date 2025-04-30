package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.PaymentCreateDto;
import by.peregud.initech.llc.dto.PaymentDto;
import by.peregud.initech.llc.entity.PaymentEntity;
import by.peregud.initech.llc.mapper.PaymentMapper;
import by.peregud.initech.llc.repository.PaymentRepository;
import by.peregud.initech.llc.service.PaymentService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@CacheConfig(cacheNames = "application")
public class PaymentServiceImpl extends BaseServiceImpl<PaymentCreateDto, PaymentDto, PaymentEntity> implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;


    public PaymentServiceImpl(PaymentRepository repository, PaymentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    protected String getDefaultSortField(){
        return PAYMENT_DATE;
    }

    protected Sort.Direction getDefaultSortDirection(){
        return Sort.Direction.DESC;
    }
}
