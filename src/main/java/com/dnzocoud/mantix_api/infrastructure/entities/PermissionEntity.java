package com.dnzocoud.mantix_api.infrastructure.entities;

import java.util.HashSet;
import java.util.Set;

import com.dnzocoud.mantix_api.domain.abstracts.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "permissions")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String icon;

    @ManyToMany(mappedBy = Constants.MAPPED_MANY_BY_PERMISSIONS)
    private Set<RoleEntity> roles = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_PERMISSION)
    private Set<UserPermissionEntity> users = new HashSet<>();
}
