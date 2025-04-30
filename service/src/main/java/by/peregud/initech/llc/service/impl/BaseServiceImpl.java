package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.BaseCreateDto;
import by.peregud.initech.llc.dto.BaseDto;
import by.peregud.initech.llc.entity.BaseEntity;
import by.peregud.initech.llc.mapper.BaseMapper;
import by.peregud.initech.llc.repository.BaseRepository;
import by.peregud.initech.llc.service.BaseService;
import by.peregud.initech.llc.service.PageableService;
import by.peregud.initech.llc.service.sortFields.SortFieldsProvider;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@CacheConfig(cacheNames = "application")
public abstract class BaseServiceImpl<C extends BaseCreateDto, D extends BaseDto, E extends BaseEntity>
        implements BaseService<C, D>, PageableService<D>,SortFieldsProvider {

    protected static final int PAGE_SIZE = 10;

    protected final BaseRepository<E> repository;
    protected final BaseMapper<C, D, E> mapper;

    protected String getDefaultSortField(){
        return ID;
    }
    protected Sort.Direction getDefaultSortDirection(){
        return Sort.Direction.ASC;
    }


    @Override
    public List<D> findAllPageable(int page) {

        return findAllPageable(page,getDefaultSortDirection());
    }

    @Override
    public List<D> findAllPageable(int page, Sort.Direction direction) {

        if(direction==null){
            direction=getDefaultSortDirection();
        }

        Sort sort = Sort.by(direction,getDefaultSortField());

        return repository.findAll(PageRequest.of(page, PAGE_SIZE, sort))
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }


    @Override
    public List<D> findAllPageableCustomSorted(int page, String... sortBy) {
        Sort sort;

        if(sortBy!=null&&sortBy.length>0) {
            sort = Sort.by(Arrays.stream(sortBy)
                    .map(field -> new Sort.Order(getDefaultSortDirection(), field)).collect(Collectors.toList()));
        }else {
            sort = Sort.by(getDefaultSortDirection(),getDefaultSortField());
        }

        return repository.findAll(PageRequest.of(page, PAGE_SIZE, sort))
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public Optional<D> update(D dto) {

        E entity = repository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + dto.getId() + " not found"));
        mapper.updateFromDto(dto, entity);

        return Optional.of(mapper.toDto(entity));

    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public Optional<D> save(C createDto) {

        E entity = mapper.toEntity(createDto);
        E saved = repository.save(entity);
        return Optional.of(mapper.toDto(saved));

    }

    @Override
    @Cacheable
    public List<D> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<D> findById(long id) {

        return repository.findById(id).map(mapper::toDto);
    }


    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public boolean delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return true;
        }

        return false;
    }

    @Override
    public boolean showPagination() {
        return repository.count() > PAGE_SIZE;
    }

    @Override
    public int getTotalPages() {
        return repository.findAll(Pageable.ofSize(PAGE_SIZE)).getTotalPages();
    }
}
