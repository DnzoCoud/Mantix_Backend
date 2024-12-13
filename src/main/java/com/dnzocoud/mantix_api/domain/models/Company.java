package com.dnzocoud.mantix_api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Company {
    private Long id;
    private String name;
    private String sector;
    private String ubication;
    private String status;
    private String configuration;
    private Country country;
    private City city;
    private Department department;
}
