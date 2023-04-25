package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.UserResponseDTO;
import com.apiuniversity.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    @Mappings({
            @Mapping(target = "idUser", source = "user.idUser"),
            @Mapping(target = "lastName", source = "user.lastName"),
            @Mapping(target = "firstName", source = "user.firstName"),
            @Mapping(target = "typeIdentification", source = "user.typeIdentification.nameIdentification"),
            @Mapping(target = "identification", source = "user.identification"),
            @Mapping(target = "phone", source = "user.phone"),
            @Mapping(target = "email", source = "user.email"),
            @Mapping(target = "user.roles", ignore = true)
    })
    UserResponseDTO userToUserResponseDto(User user);

    /*
    default UserDto userToUserResponseDto(User user) {
        UserDto dto = new UserDto();
        dto.setIdUser(user.getIdUser());
        dto.setLastName(user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setIdentification(user.getIdentification());
        dto.setTypeIdentification(user.getTypeIdentification().getNameIdentification());
        dto.setPhone(user.getPhone());
        dto.setEmail(user.getEmail());

        return dto;
    }
    */
    List<UserResponseDTO> toUsersDTO(List<User> usersEntity);

}
