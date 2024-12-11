package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.UserDTO;
import com.gategroup.mantix_api.domain.models.User;
import com.gategroup.mantix_api.infrastructure.entities.UserEntity;

public class UserMapper {

    public static UserDTO toDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(RoleMapper.toDto(user.getRole()));
        userDto.setCompany(CompanyMapper.toDto(user.getCompany()));
        userDto.setSubCompany(SubcompanyMapper.toDto(user.getSubCompany()));
        userDto.setFullName(user.getFullName());
        return userDto;
    }

    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                RoleMapper.toDomain(userEntity.getRole()),
                null, null);
    }
}
