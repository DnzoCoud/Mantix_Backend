package com.gategroup.mantix_api.application.usecases.auth;

import com.gategroup.mantix_api.domain.models.User;

public class VerifyUserPermission implements IVerifyUserPermission {
    @Override
    public boolean hasPermission(User user, String permissionName) {
        return false;
    }
}
