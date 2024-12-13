package com.dnzocoud.mantix_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PermissionDTO {
    private Long id;
    private String name;
    private String icon;
}
