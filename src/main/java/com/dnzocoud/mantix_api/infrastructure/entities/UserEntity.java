package com.dnzocoud.mantix_api.infrastructure.entities;

import java.util.HashSet;
import java.util.Set;

import com.dnzocoud.mantix_api.domain.abstracts.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class UserEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "subcompany_id")
    private SubCompanyEntity subCompany;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @OneToMany(mappedBy = Constants.MAPPED_BY_USER)
    private Set<UserPermissionEntity> permissions = new HashSet<>();

    @OneToMany(mappedBy = "director")
    private Set<AreaEntity> areas = new HashSet<>();

    @OneToMany(mappedBy = "manager")
    private Set<LocationEntity> locations = new HashSet<>();

    @OneToMany(mappedBy = "changedByUser")
    private Set<MaintenanceStatusHistoryEntity> maintenanceStatusHistory = new HashSet<>();

    @OneToMany(mappedBy = "technician")
    private Set<MaintenanceActivityEntity> maintenanceActivities = new HashSet<>();

    @ManyToMany(mappedBy = "technicians")
    private Set<MaintenanceEntity> maintenances = new HashSet<>();
}
