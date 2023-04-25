package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.SubjectDTO;
import com.apiuniversity.entity.Subject;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    
    SubjectDTO SubjectToDTO(Subject subject);

    @InheritInverseConfiguration
    Subject dtoToSubject(SubjectDTO subject);

    List<SubjectDTO> toSubjectDTOs(List<Subject> subjects);
}
