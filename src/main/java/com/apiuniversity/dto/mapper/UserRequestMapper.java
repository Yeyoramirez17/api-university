package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.UserRequestDTO;
import com.apiuniversity.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    @Mappings({
            @Mapping(target = "idUser", source = "user.idUser"),
            @Mapping(target = "lastName", source = "user.lastName"),
            @Mapping(target = "firstName", source = "user.firstName"),
            @Mapping(target = "typeIdentification", source = "user.typeIdentification"),
            @Mapping(target = "identification", source = "user.identification"),
            @Mapping(target = "phone", source = "user.phone"),
            @Mapping(target = "email", source = "user.email"),
            @Mapping(target = "username", source = "user.username"),
            @Mapping(target = "password", source = "user.password"),
            @Mapping(target = "roles", source = "user.roles")
    })
    UserRequestDTO userToDtoRequest(User user);

    @InheritInverseConfiguration
    User dtoRequestToUser(UserRequestDTO dto);
}
