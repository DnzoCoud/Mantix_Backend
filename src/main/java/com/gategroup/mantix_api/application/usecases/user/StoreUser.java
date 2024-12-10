package com.gategroup.mantix_api.application.usecases.user;

import com.gategroup.mantix_api.application.dto.StoreUserRequestDTO;
import com.gategroup.mantix_api.application.dto.UserDTO;
import com.gategroup.mantix_api.domain.models.User;
import com.gategroup.mantix_api.domain.services.IUserService;
import com.gategroup.mantix_api.infrastructure.adapters.LoggableException;
import com.gategroup.mantix_api.infrastructure.exceptions.FailOperationException;
import com.gategroup.mantix_api.presentation.mappers.UserMapper;

public class StoreUser {
    private static final LoggableException logger = LoggableException.getLogger("users", StoreUser.class);

    private final IUserService userService;

    public StoreUser(IUserService userService) {
        this.userService = userService;
    }

    public UserDTO execute(StoreUserRequestDTO storeUserRequestDTO) {
        try {
            User userToAdd = new User(
                    null,
                    storeUserRequestDTO.getUsername(),
                    storeUserRequestDTO.getFirstName(),
                    storeUserRequestDTO.getLastName(),
                    storeUserRequestDTO.getEmail(),
                    storeUserRequestDTO.getPassword(),
                    null, null);

            userToAdd = userService.store(userToAdd);
            return UserMapper.toDto(userToAdd);
        } catch (Exception e) {
            logger.error("Error al registrar usuario.", e);
            throw new FailOperationException("Error al registrar usuario.Error ID: " + logger.getUniqueId());
        }
    }
}
