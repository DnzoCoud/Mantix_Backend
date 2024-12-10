package com.gategroup.mantix_api.domain.services;

import com.gategroup.mantix_api.domain.models.User;

public interface ITokenService {
    String generateToken(User user);

    boolean validateToken(String token);

    <T> T validateTokenAndReturnClaims(String token);
}
