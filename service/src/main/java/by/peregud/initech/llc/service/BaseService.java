package by.peregud.initech.llc.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<C,D> {
    Optional<D> save(C createDto);

    List<D> findAll();

    Optional<D> findById(long id);

    Optional<D> update(D dto);

    boolean delete(long id);

    boolean showPagination();

    int getTotalPages();
}
