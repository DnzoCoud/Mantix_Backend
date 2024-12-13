package com.dnzocoud.mantix_api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class City {
    private Long id;
    private String name;
    private String code;
    private Country country;
    private Department department;
}
