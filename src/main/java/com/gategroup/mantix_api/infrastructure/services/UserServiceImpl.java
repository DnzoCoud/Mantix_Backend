package com.gategroup.mantix_api.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gategroup.mantix_api.domain.models.User;
import com.gategroup.mantix_api.domain.services.IUserService;
import com.gategroup.mantix_api.infrastructure.entities.UserEntity;
import com.gategroup.mantix_api.infrastructure.persistence.UserRepositoryJpa;
import com.gategroup.mantix_api.presentation.mappers.UserMapper;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepositoryJpa userRepositoryJpa;

    @Autowired
    public UserServiceImpl(UserRepositoryJpa userRepository) {
        this.userRepositoryJpa = userRepository;
    }

    @Override
    public Optional<User> find(Long id) {
        Optional<UserEntity> userEntity = userRepositoryJpa.findById(id);
        return userEntity.map(UserMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepositoryJpa.findAll();
        return userEntities.stream().map(UserMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public User store(User usuario) {
        return null;
    }

}
