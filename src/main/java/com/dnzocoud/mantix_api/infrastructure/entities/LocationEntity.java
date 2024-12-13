package com.dnzocoud.mantix_api.infrastructure.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaEntity area;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private UserEntity manager;

    @OneToMany(mappedBy = "location")
    private Set<MachineEntity> machines = new HashSet<>();
}
