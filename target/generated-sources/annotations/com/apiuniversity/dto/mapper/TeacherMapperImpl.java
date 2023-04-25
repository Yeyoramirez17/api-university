package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.TeacherDTO;
import com.apiuniversity.dto.TypeIdentificationDTO;
import com.apiuniversity.entity.Teacher;
import com.apiuniversity.entity.TypeIdentification;
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
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDTO teacherToDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setIdTeacher( teacher.getIdTeacher() );
        teacherDTO.setFirstName( teacher.getFirstName() );
        teacherDTO.setLastName( teacher.getLastName() );
        teacherDTO.setTypeIdentification( typeIdentificationToTypeIdentificationDTO( teacher.getTypeIdentification() ) );
        teacherDTO.setIdentification( teacher.getIdentification() );
        teacherDTO.setBirthdate( teacher.getBirthdate() );
        teacherDTO.setPhone( teacher.getPhone() );
        teacherDTO.setEmail( teacher.getEmail() );
        teacherDTO.setSalary( teacher.getSalary() );
        teacherDTO.setDateAdmission( teacher.getDateAdmission() );

        return teacherDTO;
    }

    @Override
    public Teacher dtoToTeacher(TeacherDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setIdTeacher( dto.getIdTeacher() );
        teacher.setFirstName( dto.getFirstName() );
        teacher.setLastName( dto.getLastName() );
        teacher.setTypeIdentification( typeIdentificationDTOToTypeIdentification( dto.getTypeIdentification() ) );
        teacher.setIdentification( dto.getIdentification() );
        teacher.setBirthdate( dto.getBirthdate() );
        teacher.setPhone( dto.getPhone() );
        teacher.setEmail( dto.getEmail() );
        teacher.setSalary( dto.getSalary() );
        teacher.setDateAdmission( dto.getDateAdmission() );

        return teacher;
    }

    @Override
    public List<TeacherDTO> toTeacherDTOs(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherDTO> list = new ArrayList<TeacherDTO>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( teacherToDTO( teacher ) );
        }

        return list;
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
}
