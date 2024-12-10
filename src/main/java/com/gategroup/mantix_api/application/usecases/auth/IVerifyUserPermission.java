package com.gategroup.mantix_api.application.usecases.auth;

import com.gategroup.mantix_api.domain.models.User;

public interface IVerifyUserPermission {
    boolean hasPermission(User user, String permissionName);
}
