package com.dnzocoud.mantix_api.domain.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MaintenanceDay {
    private Long id;
    private LocalDate date;
    private boolean completed;
    private Company company;
    private SubCompany subCompany;
}
