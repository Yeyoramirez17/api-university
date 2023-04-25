package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.FacultyDTO;
import com.apiuniversity.entity.Faculty;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    
    FacultyDTO FacultyToDTO(Faculty faculty);

    @InheritInverseConfiguration
    Faculty dtoToFaculty(FacultyDTO faculty);

    List<FacultyDTO> toFacultyDTOs(List<Faculty> faculties);
}
