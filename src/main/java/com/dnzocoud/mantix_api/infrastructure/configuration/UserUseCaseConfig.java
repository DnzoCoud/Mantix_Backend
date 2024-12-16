package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.company.GetCompanyById;
import com.dnzocoud.mantix_api.application.usecases.role.GetRoleById;
import com.dnzocoud.mantix_api.application.usecases.user.FindAllUsers;
import com.dnzocoud.mantix_api.application.usecases.user.StoreUser;
import com.dnzocoud.mantix_api.domain.services.IUserService;

@Configuration
public class UserUseCaseConfig {

    private final IUserService userService;
    private final GetRoleById getRoleById;
    private final GetCompanyById getCompanyById;

    @Autowired
    public UserUseCaseConfig(
            IUserService userService,
            GetRoleById getRoleById,
            GetCompanyById getCompanyById) {
        this.userService = userService;
        this.getRoleById = getRoleById;
        this.getCompanyById = getCompanyById;
    }

    @Bean
    public FindAllUsers findAllUsers() {
        return new FindAllUsers(userService);
    }

    @Bean
    public StoreUser storeUser() {
        return new StoreUser(userService, getRoleById, getCompanyById);
    }
}
