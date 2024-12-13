package com.dnzocoud.mantix_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubcompanyDTO {
    private Long id;
    private String name;
    private String sector;
    private String ubication;
    private String status;
    private String configuration;
    private CountryDTO country;
    private CityDTO city;
    private DepartmentDTO department;
}
