package com.gategroup.mantix_api.application.usecases.auth;

import com.gategroup.mantix_api.domain.models.Permission;
import java.util.HashSet;
import java.util.Set;

import com.gategroup.mantix_api.domain.models.User;

public class VerifyUserPermission implements IVerifyUserPermission {
    @Override
    public boolean hasPermission(User user, String permissionName) {
        if (user == null) {
            return false;
        }
        Set<Permission> totalPermissions = new HashSet<>();

        if (user.getRole() != null) {
            totalPermissions.addAll(user.getRole().getPermissions());
        }
        totalPermissions.addAll(user.getPermissions());

        return totalPermissions.stream().anyMatch(permission -> permission.getName().equalsIgnoreCase(permissionName));
    }
}
