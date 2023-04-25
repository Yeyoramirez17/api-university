package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.UserResponseDTO;
import com.apiuniversity.entity.TypeIdentification;
import com.apiuniversity.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-22T21:54:18-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class UserResponseMapperImpl implements UserResponseMapper {

    @Override
    public UserResponseDTO userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setIdUser( user.getIdUser() );
        userResponseDTO.setLastName( user.getLastName() );
        userResponseDTO.setFirstName( user.getFirstName() );
        userResponseDTO.setTypeIdentification( userTypeIdentificationNameIdentification( user ) );
        userResponseDTO.setIdentification( user.getIdentification() );
        userResponseDTO.setPhone( user.getPhone() );
        userResponseDTO.setEmail( user.getEmail() );

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> toUsersDTO(List<User> usersEntity) {
        if ( usersEntity == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( usersEntity.size() );
        for ( User user : usersEntity ) {
            list.add( userToUserResponseDto( user ) );
        }

        return list;
    }

    private String userTypeIdentificationNameIdentification(User user) {
        if ( user == null ) {
            return null;
        }
        TypeIdentification typeIdentification = user.getTypeIdentification();
        if ( typeIdentification == null ) {
            return null;
        }
        String nameIdentification = typeIdentification.getNameIdentification();
        if ( nameIdentification == null ) {
            return null;
        }
        return nameIdentification;
    }
}
