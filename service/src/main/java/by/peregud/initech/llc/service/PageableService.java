package by.peregud.initech.llc.service;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface PageableService<D> {
    List<D> findAllPageable(int page);

    List<D> findAllPageable(int page, Sort.Direction direction);
    List<D> findAllPageableCustomSorted(int page, String... sortBy);
}
