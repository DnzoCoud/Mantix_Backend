package com.dnzocoud.mantix_api.application.usecases.user;

import java.util.Optional;

import com.dnzocoud.mantix_api.application.dto.UserDTO;
import com.dnzocoud.mantix_api.application.mappers.UserMapper;
import com.dnzocoud.mantix_api.domain.services.IUserService;

public class FindUserById {
    private final IUserService userService;

    public FindUserById(IUserService userService) {
        this.userService = userService;
    }

    public Optional<UserDTO> execute(Long id) {
        return userService.find(id).map(UserMapper::toDto);
    }
}
