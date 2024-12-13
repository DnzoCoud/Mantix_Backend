package com.dnzocoud.mantix_api.domain.services;

import java.util.List;
import java.util.Optional;

public interface IBasicService<T> {
    Optional<T> find(Long id);

    List<T> findAll();

    T store(T domain);

    T update(T domain);

    boolean destroy(Long id);
}
