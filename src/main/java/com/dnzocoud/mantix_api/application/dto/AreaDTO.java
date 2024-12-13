package com.dnzocoud.mantix_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AreaDTO {
    private Long id;
    private String name;
    private CompanyDTO company;
    private SubcompanyDTO subCompany;
    private UserDTO director;
}
