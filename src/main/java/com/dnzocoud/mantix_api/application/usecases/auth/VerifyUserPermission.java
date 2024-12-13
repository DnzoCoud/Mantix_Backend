package com.dnzocoud.mantix_api.application.usecases.auth;

import com.dnzocoud.mantix_api.domain.models.User;

public class VerifyUserPermission implements IVerifyUserPermission {
    @Override
    public boolean hasPermission(User user, String permissionName) {
        return false;
    }
}
