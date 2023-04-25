package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.RoleDTO;
import com.apiuniversity.entity.Role;
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
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO roleToDTO(Role role) {
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

    @Override
    public Role dtoToRole(RoleDTO role) {
        if ( role == null ) {
            return null;
        }

        Role role1 = new Role();

        role1.setIdRole( role.getIdRole() );
        role1.setRoleName( role.getRoleName() );
        role1.setDescription( role.getDescription() );
        role1.setIsActive( role.getIsActive() );

        return role1;
    }

    @Override
    public List<RoleDTO> toRoleDTO(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( roleToDTO( role ) );
        }

        return list;
    }
}
