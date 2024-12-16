package com.dnzocoud.mantix_api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Area {
    private Long id;
    private String name;
    private Company company;
    private SubCompany subCompany;
    private User director;
}
