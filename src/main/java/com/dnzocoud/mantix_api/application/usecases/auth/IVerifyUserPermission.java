package com.dnzocoud.mantix_api.application.usecases.auth;

import com.dnzocoud.mantix_api.domain.models.User;

public interface IVerifyUserPermission {
    boolean hasPermission(User user, String permissionName);
}
