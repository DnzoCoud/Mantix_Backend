package com.dnzocoud.mantix_api.application.usecases.user;

import java.util.List;
import java.util.stream.Collectors;

import com.dnzocoud.mantix_api.application.dto.UserDTO;
import com.dnzocoud.mantix_api.application.mappers.UserMapper;
import com.dnzocoud.mantix_api.domain.services.IUserService;

public class FindAllUsers {
    private final IUserService userService;

    public FindAllUsers(IUserService userService) {
        this.userService = userService;
    }

    public List<UserDTO> execute() {
        return userService.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
}
