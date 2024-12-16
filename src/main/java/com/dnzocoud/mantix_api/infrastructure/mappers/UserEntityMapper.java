package com.dnzocoud.mantix_api.infrastructure.mappers;

import com.dnzocoud.mantix_api.domain.models.User;
import com.dnzocoud.mantix_api.infrastructure.entities.UserEntity;

public final class UserEntityMapper {

    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getSalt(),
                RoleEntityMapper.toDomain(userEntity.getRole()),
                CompanyEntityMapper.toDomain(userEntity.getCompany()),
                SubcompanyEntityMapper.toDomain(userEntity.getSubCompany()));
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setSalt(user.getSalt());
        userEntity.setRole(RoleEntityMapper.toEntity(user.getRole()));
        userEntity.setCompany(CompanyEntityMapper.toEntity(user.getCompany()));
        userEntity.setSubCompany(SubcompanyEntityMapper.toEntity(user.getSubCompany()));
        return userEntity;
    }
}
