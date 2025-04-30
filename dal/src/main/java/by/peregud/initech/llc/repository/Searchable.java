package by.peregud.initech.llc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface Searchable<T>{

    Page<T> searchByData(String data, Pageable pageable);
}
