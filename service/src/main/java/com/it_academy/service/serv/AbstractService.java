package com.it_academy.service.serv;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbstractService<T, K> {

    T create(T t);

    Page<T> getAll(Pageable pageable);

    T get(K id);

    T update(T t);

    void delete(K id);

}