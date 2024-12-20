package com.dnzocoud.mantix_api.domain.services;

import java.util.List;
import java.util.Optional;

import com.dnzocoud.mantix_api.domain.models.User;

public interface IUserService {
    Optional<User> find(Long id);

    List<User> findAll();

    User store(User usuario);
}
