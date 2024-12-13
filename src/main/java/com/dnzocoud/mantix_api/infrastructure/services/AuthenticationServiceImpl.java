package com.dnzocoud.mantix_api.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.models.User;
import com.dnzocoud.mantix_api.domain.services.AuthenticacionService;
import com.dnzocoud.mantix_api.infrastructure.entities.UserEntity;
import com.dnzocoud.mantix_api.infrastructure.mappers.UserEntityMapper;
import com.dnzocoud.mantix_api.infrastructure.persistence.UserRepositoryJpa;

@Service
public class AuthenticationServiceImpl implements AuthenticacionService {
    private final UserRepositoryJpa userRepositoryJpa;

    @Autowired
    public AuthenticationServiceImpl(UserRepositoryJpa userRepository) {
        this.userRepositoryJpa = userRepository;
    }

    @Override
    public User login(String email, String password) {
        UserEntity user = userRepositoryJpa.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no existe o esta inactivo."));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Credenciales invalidas");
        }
        return UserEntityMapper.toDomain(user);
    }
}
