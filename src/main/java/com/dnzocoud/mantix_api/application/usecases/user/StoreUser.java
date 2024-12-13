package com.dnzocoud.mantix_api.application.usecases.user;

import com.dnzocoud.mantix_api.application.dto.UserDTO;
import com.dnzocoud.mantix_api.application.dto.request.StoreUserRequestDTO;
import com.dnzocoud.mantix_api.application.mappers.UserMapper;
import com.dnzocoud.mantix_api.domain.models.User;
import com.dnzocoud.mantix_api.domain.services.IUserService;
import com.dnzocoud.mantix_api.infrastructure.adapters.LoggableException;
import com.dnzocoud.mantix_api.infrastructure.exceptions.FailOperationException;

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
                    null, null, null);

            userToAdd = userService.store(userToAdd);
            return UserMapper.toDto(userToAdd);
        } catch (Exception e) {
            logger.error("Error al registrar usuario.", e);
            throw new FailOperationException("Error al registrar usuario.Error ID: " + logger.getUniqueId());
        }
    }
}
