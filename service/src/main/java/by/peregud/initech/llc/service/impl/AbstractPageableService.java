package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.BaseDto;
import by.peregud.initech.llc.service.PageableService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractPageableService <E, D extends BaseDto> implements PageableService<D> {

    private static final int PAGE_SIZE=10;

    protected abstract JpaRepository<E,?> getRepository();
    protected abstract Function<E,D>getMapper();

    @Override
    public List<D> findAllPageable(int page) {
        return getRepository().findAll(PageRequest.of(page, PAGE_SIZE, Sort.unsorted()))
                .stream().map(getMapper()).collect(Collectors.toList());
    }

    @Override
    public List<D> findAllPageableCustomSorted(int page, String... sortBy) {
        Sort sort = Sort.unsorted();
        if(sortBy!=null&&sortBy.length>0) {
            sort = Sort.by(Arrays.stream(sortBy).map(Sort.Order::asc).collect(Collectors.toList()));
        }

        return getRepository().findAll(PageRequest.of(page, PAGE_SIZE, sort))
                .stream().map(getMapper()).collect(Collectors.toList());
    }
}
