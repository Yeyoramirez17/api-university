package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.FacultyDTO;
import com.apiuniversity.dto.SubjectDTO;
import com.apiuniversity.dto.TeacherDTO;
import com.apiuniversity.dto.TeacherSubjectDTO;
import com.apiuniversity.dto.TypeIdentificationDTO;
import com.apiuniversity.entity.Faculty;
import com.apiuniversity.entity.Subject;
import com.apiuniversity.entity.Teacher;
import com.apiuniversity.entity.TeacherSubject;
import com.apiuniversity.entity.TypeIdentification;
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
public class TeacherSubjectMapperImpl implements TeacherSubjectMapper {

    @Override
    public TeacherSubjectDTO teacherSubjectToDTO(TeacherSubject teacherSubject) {
        if ( teacherSubject == null ) {
            return null;
        }

        TeacherSubjectDTO teacherSubjectDTO = new TeacherSubjectDTO();

        teacherSubjectDTO.setTeacher( teacherToTeacherDTO( teacherSubject.getTeacher() ) );
        teacherSubjectDTO.setSubject( subjectToSubjectDTO( teacherSubject.getSubject() ) );
        teacherSubjectDTO.setHours( teacherSubject.getHours() );

        return teacherSubjectDTO;
    }

    @Override
    public TeacherSubject dtoToTeacherSubject(TeacherSubjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TeacherSubject teacherSubject = new TeacherSubject();

        teacherSubject.setTeacher( teacherDTOToTeacher( dto.getTeacher() ) );
        teacherSubject.setSubject( subjectDTOToSubject( dto.getSubject() ) );
        teacherSubject.setHours( dto.getHours() );

        return teacherSubject;
    }

    @Override
    public List<TeacherSubjectDTO> toTeacherSubjectDTOs(List<TeacherSubject> list) {
        if ( list == null ) {
            return null;
        }

        List<TeacherSubjectDTO> list1 = new ArrayList<TeacherSubjectDTO>( list.size() );
        for ( TeacherSubject teacherSubject : list ) {
            list1.add( teacherSubjectToDTO( teacherSubject ) );
        }

        return list1;
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

    protected TeacherDTO teacherToTeacherDTO(Teacher teacher) {
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

    protected FacultyDTO facultyToFacultyDTO(Faculty faculty) {
        if ( faculty == null ) {
            return null;
        }

        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setIdFaculty( faculty.getIdFaculty() );
        facultyDTO.setNameFaculty( faculty.getNameFaculty() );
        facultyDTO.setDirection( faculty.getDirection() );
        facultyDTO.setPhone( faculty.getPhone() );
        facultyDTO.setEmail( faculty.getEmail() );

        return facultyDTO;
    }

    protected SubjectDTO subjectToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setIdSubject( subject.getIdSubject() );
        subjectDTO.setNameSubject( subject.getNameSubject() );
        subjectDTO.setCredits( subject.getCredits() );
        subjectDTO.setState( subject.getState() );
        subjectDTO.setFaculty( facultyToFacultyDTO( subject.getFaculty() ) );

        return subjectDTO;
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

    protected Teacher teacherDTOToTeacher(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setIdTeacher( teacherDTO.getIdTeacher() );
        teacher.setFirstName( teacherDTO.getFirstName() );
        teacher.setLastName( teacherDTO.getLastName() );
        teacher.setTypeIdentification( typeIdentificationDTOToTypeIdentification( teacherDTO.getTypeIdentification() ) );
        teacher.setIdentification( teacherDTO.getIdentification() );
        teacher.setBirthdate( teacherDTO.getBirthdate() );
        teacher.setPhone( teacherDTO.getPhone() );
        teacher.setEmail( teacherDTO.getEmail() );
        teacher.setSalary( teacherDTO.getSalary() );
        teacher.setDateAdmission( teacherDTO.getDateAdmission() );

        return teacher;
    }

    protected Faculty facultyDTOToFaculty(FacultyDTO facultyDTO) {
        if ( facultyDTO == null ) {
            return null;
        }

        Faculty faculty = new Faculty();

        faculty.setIdFaculty( facultyDTO.getIdFaculty() );
        faculty.setNameFaculty( facultyDTO.getNameFaculty() );
        faculty.setDirection( facultyDTO.getDirection() );
        faculty.setPhone( facultyDTO.getPhone() );
        faculty.setEmail( facultyDTO.getEmail() );

        return faculty;
    }

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setIdSubject( subjectDTO.getIdSubject() );
        subject.setNameSubject( subjectDTO.getNameSubject() );
        subject.setCredits( subjectDTO.getCredits() );
        subject.setState( subjectDTO.getState() );
        subject.setFaculty( facultyDTOToFaculty( subjectDTO.getFaculty() ) );

        return subject;
    }
}
