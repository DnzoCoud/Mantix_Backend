package com.dnzocoud.mantix_api.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.models.User;
import com.dnzocoud.mantix_api.domain.services.AuthenticacionService;
import com.dnzocoud.mantix_api.domain.services.IPasswordHashing;
import com.dnzocoud.mantix_api.infrastructure.entities.UserEntity;
import com.dnzocoud.mantix_api.infrastructure.mappers.UserEntityMapper;
import com.dnzocoud.mantix_api.infrastructure.persistence.UserRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticacionService {
    private final UserRepositoryJpa userRepositoryJpa;
    private final IPasswordHashing passwordHashing;

    @Autowired
    public AuthenticationServiceImpl(UserRepositoryJpa userRepository, IPasswordHashing passwordHashing) {
        this.userRepositoryJpa = userRepository;
        this.passwordHashing = passwordHashing;
    }

    @Override
    @Transactional
    public User login(String email, String password) {
        UserEntity user = userRepositoryJpa.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no existe o esta inactivo."));

        if (!passwordHashing.veirfyPassword(password, user.getSalt(), user.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }
        return UserEntityMapper.toDomain(user);
    }
}
