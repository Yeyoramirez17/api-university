package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.TeacherSubjectDTO;
import com.apiuniversity.entity.TeacherSubject;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherSubjectMapper {
    
    TeacherSubjectDTO teacherSubjectToDTO(TeacherSubject teacherSubject);

    @InheritInverseConfiguration
    TeacherSubject dtoToTeacherSubject(TeacherSubjectDTO dto);

    List<TeacherSubjectDTO> toTeacherSubjectDTOs(List<TeacherSubject> list);
}
