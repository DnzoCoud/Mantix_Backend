package com.dnzocoud.mantix_api.domain.services;

import com.dnzocoud.mantix_api.domain.models.User;

public interface AuthenticacionService {
    User login(String email, String password);

}
