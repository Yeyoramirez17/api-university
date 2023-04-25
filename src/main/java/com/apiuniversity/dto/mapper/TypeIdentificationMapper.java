package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.TypeIdentificationDTO;
import com.apiuniversity.entity.TypeIdentification;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeIdentificationMapper {

    @Mappings({
            @Mapping(target = "idTypeIdentification", source = "typeIdentification.idTypeIdentification"),
            @Mapping(target = "nameIdentification", source = "typeIdentification.nameIdentification"),
            @Mapping(target = "description", source = "typeIdentification.description"),
            @Mapping(target = "state", source = "typeIdentification.state")
    })
    TypeIdentificationDTO typeIdentificationToDTO(TypeIdentification typeIdentification);

    @InheritInverseConfiguration
    TypeIdentification dtoToTypeIdentification(TypeIdentificationDTO dto);

    List<TypeIdentificationDTO> toTypeIdentificationDTO(List<TypeIdentification> typeIdentifications);
}
