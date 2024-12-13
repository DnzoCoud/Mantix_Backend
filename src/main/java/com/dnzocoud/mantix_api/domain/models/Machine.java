package com.dnzocoud.mantix_api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Machine {
    private Long id;
    private String name;
    private String model;
    private String serial;
    private Location location;
}
