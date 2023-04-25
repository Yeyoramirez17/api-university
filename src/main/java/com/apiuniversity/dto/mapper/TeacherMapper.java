package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.TeacherDTO;
import com.apiuniversity.entity.Teacher;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDTO teacherToDTO(Teacher teacher);

    @InheritInverseConfiguration
    Teacher dtoToTeacher(TeacherDTO dto);

    List<TeacherDTO> toTeacherDTOs(List<Teacher> teachers);
}
