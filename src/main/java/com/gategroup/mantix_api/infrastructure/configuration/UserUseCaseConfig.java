package com.gategroup.mantix_api.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gategroup.mantix_api.application.usecases.user.FindAllUsers;
import com.gategroup.mantix_api.application.usecases.user.StoreUser;
import com.gategroup.mantix_api.domain.services.IUserService;

@Configuration
public class UserUseCaseConfig {

    private final IUserService userService;

    public UserUseCaseConfig(IUserService userService) {
        this.userService = userService;
    }

    @Bean
    public FindAllUsers findAllUsers() {
        return new FindAllUsers(userService);
    }

    @Bean
    public StoreUser storeUser() {
        return new StoreUser(userService);
    }
}
