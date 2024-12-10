package com.gategroup.mantix_api.domain.services;

import com.gategroup.mantix_api.domain.models.User;

public interface AuthenticacionService {
    User login(String email, String password);

}
