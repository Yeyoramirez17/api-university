package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.RoleDTO;
import com.apiuniversity.dto.TypeIdentificationDTO;
import com.apiuniversity.dto.UserRequestDTO;
import com.apiuniversity.entity.Role;
import com.apiuniversity.entity.TypeIdentification;
import com.apiuniversity.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T18:36:33-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class UserRequestMapperImpl implements UserRequestMapper {

    @Override
    public UserRequestDTO userToDtoRequest(User user) {
        if ( user == null ) {
            return null;
        }

        UserRequestDTO userRequestDTO = new UserRequestDTO();

        userRequestDTO.setIdUser( user.getIdUser() );
        userRequestDTO.setLastName( user.getLastName() );
        userRequestDTO.setFirstName( user.getFirstName() );
        userRequestDTO.setTypeIdentification( typeIdentificationToTypeIdentificationDTO( user.getTypeIdentification() ) );
        userRequestDTO.setIdentification( user.getIdentification() );
        userRequestDTO.setPhone( user.getPhone() );
        userRequestDTO.setEmail( user.getEmail() );
        userRequestDTO.setUsername( user.getUsername() );
        userRequestDTO.setPassword( user.getPassword() );
        userRequestDTO.setRoles( roleListToRoleDTOList( user.getRoles() ) );

        return userRequestDTO;
    }

    @Override
    public User dtoRequestToUser(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setIdUser( dto.getIdUser() );
        user.setLastName( dto.getLastName() );
        user.setFirstName( dto.getFirstName() );
        user.setTypeIdentification( typeIdentificationDTOToTypeIdentification( dto.getTypeIdentification() ) );
        user.setIdentification( dto.getIdentification() );
        user.setPhone( dto.getPhone() );
        user.setEmail( dto.getEmail() );
        user.setUsername( dto.getUsername() );
        user.setPassword( dto.getPassword() );
        user.setRoles( roleDTOListToRoleList( dto.getRoles() ) );

        return user;
    }

    protected TypeIdentificationDTO typeIdentificationToTypeIdentificationDTO(TypeIdentification typeIdentification) {
        if ( typeIdentification == null ) {
            return null;
        }

        TypeIdentificationDTO typeIdentificationDTO = new TypeIdentificationDTO();

        typeIdentificationDTO.setIdTypeIdentification( typeIdentification.getIdTypeIdentification() );
        typeIdentificationDTO.setNameIdentification( typeIdentification.getNameIdentification() );
        typeIdentificationDTO.setDescription( typeIdentification.getDescription() );
        typeIdentificationDTO.setState( typeIdentification.getState() );

        return typeIdentificationDTO;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setIdRole( role.getIdRole() );
        roleDTO.setRoleName( role.getRoleName() );
        roleDTO.setDescription( role.getDescription() );
        roleDTO.setIsActive( role.getIsActive() );

        return roleDTO;
    }

    protected List<RoleDTO> roleListToRoleDTOList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleDTO> list1 = new ArrayList<RoleDTO>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleDTO( role ) );
        }

        return list1;
    }

    protected TypeIdentification typeIdentificationDTOToTypeIdentification(TypeIdentificationDTO typeIdentificationDTO) {
        if ( typeIdentificationDTO == null ) {
            return null;
        }

        TypeIdentification typeIdentification = new TypeIdentification();

        typeIdentification.setIdTypeIdentification( typeIdentificationDTO.getIdTypeIdentification() );
        typeIdentification.setNameIdentification( typeIdentificationDTO.getNameIdentification() );
        typeIdentification.setDescription( typeIdentificationDTO.getDescription() );
        typeIdentification.setState( typeIdentificationDTO.getState() );

        return typeIdentification;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setIdRole( roleDTO.getIdRole() );
        role.setRoleName( roleDTO.getRoleName() );
        role.setDescription( roleDTO.getDescription() );
        role.setIsActive( roleDTO.getIsActive() );

        return role;
    }

    protected List<Role> roleDTOListToRoleList(List<RoleDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( RoleDTO roleDTO : list ) {
            list1.add( roleDTOToRole( roleDTO ) );
        }

        return list1;
    }
}
