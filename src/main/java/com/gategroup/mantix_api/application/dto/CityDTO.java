package com.gategroup.mantix_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDTO {
    private Long id;
    private String name;
    private String code;
    private CountryDTO country;
    private DepartmentDTO department;
}
