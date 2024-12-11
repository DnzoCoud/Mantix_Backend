package com.gategroup.mantix_api.application.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaintenanceDayDTO {
    private Long id;
    private LocalDate date;
    private boolean status;
    private CompanyDTO company;
    private SubcompanyDTO subCompany;
}
