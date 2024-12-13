package com.dnzocoud.mantix_api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserPermission {
    private Long id;
    private User user;
    private Permission permission;
    private boolean allowed;
}
