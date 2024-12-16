package com.dnzocoud.mantix_api.application.usecases.user;

import com.dnzocoud.mantix_api.application.dto.UserDTO;
import com.dnzocoud.mantix_api.application.dto.request.StoreUserRequestDTO;
import com.dnzocoud.mantix_api.application.mappers.UserMapper;
import com.dnzocoud.mantix_api.application.usecases.company.GetCompanyById;
import com.dnzocoud.mantix_api.application.usecases.role.GetRoleById;
import com.dnzocoud.mantix_api.application.usecases.subCompany.GetSubCompanyById;
import com.dnzocoud.mantix_api.domain.models.Company;
import com.dnzocoud.mantix_api.domain.models.Role;
import com.dnzocoud.mantix_api.domain.models.SubCompany;
import com.dnzocoud.mantix_api.domain.models.User;
import com.dnzocoud.mantix_api.domain.services.IUserService;
import com.dnzocoud.mantix_api.infrastructure.adapters.LoggableException;
import com.dnzocoud.mantix_api.infrastructure.exceptions.FailOperationException;

public class StoreUser {
    private static final LoggableException logger = LoggableException.getLogger("users", StoreUser.class);

    private final IUserService userService;
    private final GetRoleById getRoleById;
    private final GetCompanyById getCompanyById;
    private final GetSubCompanyById getSubCompanyById;

    public StoreUser(
            IUserService userService,
            GetRoleById getRoleById,
            GetCompanyById getCompanyById,
            GetSubCompanyById getSubCompanyById) {
        this.userService = userService;
        this.getRoleById = getRoleById;
        this.getCompanyById = getCompanyById;
        this.getSubCompanyById = getSubCompanyById;
    }

    private static void validArguments(StoreUserRequestDTO storeUserRequestDTO) {
        if (storeUserRequestDTO.getCompanyId() == null && storeUserRequestDTO.getSubCompanyId() == null) {
            throw new RuntimeException("Debes especificar la compañia o la subcompañia.");
        }
    }

    public UserDTO execute(StoreUserRequestDTO storeUserRequestDTO) {
        validArguments(storeUserRequestDTO);
        try {
            Role existRole = getRoleById.execute(storeUserRequestDTO.getRoleId());
            Company existCompany = getCompanyById.execute(storeUserRequestDTO.getCompanyId());
            SubCompany existSubCompany = getSubCompanyById.execute(storeUserRequestDTO.getSubCompanyId());

            User userToAdd = new User(
                    null,
                    storeUserRequestDTO.getUsername(),
                    storeUserRequestDTO.getFirstName(),
                    storeUserRequestDTO.getLastName(),
                    storeUserRequestDTO.getEmail(),
                    storeUserRequestDTO.getPassword(),
                    existRole,
                    existCompany,
                    existSubCompany);

            userToAdd = userService.store(userToAdd);
            return UserMapper.toDto(userToAdd);
        } catch (Exception e) {
            logger.error("Error al registrar usuario.", e);
            throw new FailOperationException("Error al registrar usuario.Error ID: " + logger.getUniqueId());
        }
    }
}
