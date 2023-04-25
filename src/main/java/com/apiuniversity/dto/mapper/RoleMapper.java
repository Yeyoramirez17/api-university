package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.RoleDTO;
import com.apiuniversity.entity.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mappings({
            @Mapping(target = "idRole", source = "role.idRole"),
            @Mapping(target = "roleName", source = "role.roleName"),
            @Mapping(target = "description", source = "role.description"),
            @Mapping(target = "isActive", source = "role.isActive")
    })
    RoleDTO roleToDTO(Role role);

    @InheritInverseConfiguration
    Role dtoToRole(RoleDTO role);

    List<RoleDTO> toRoleDTO(List<Role> roles);
}
