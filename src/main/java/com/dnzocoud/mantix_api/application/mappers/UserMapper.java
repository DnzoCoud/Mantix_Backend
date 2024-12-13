package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.UserDTO;
import com.dnzocoud.mantix_api.domain.models.User;

public final class UserMapper {

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
}
