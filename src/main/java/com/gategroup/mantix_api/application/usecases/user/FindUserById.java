package com.gategroup.mantix_api.application.usecases.user;

import java.util.Optional;

import com.gategroup.mantix_api.application.dto.UserDTO;
import com.gategroup.mantix_api.domain.services.IUserService;
import com.gategroup.mantix_api.presentation.mappers.UserMapper;

public class FindUserById {
    private final IUserService userService;

    public FindUserById(IUserService userService) {
        this.userService = userService;
    }

    public Optional<UserDTO> execute(Long id) {
        return userService.find(id).map(user -> UserMapper.toDto(user));
    }
}
