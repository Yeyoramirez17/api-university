package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.FacultyDTO;
import com.apiuniversity.dto.SubjectDTO;
import com.apiuniversity.entity.Faculty;
import com.apiuniversity.entity.Subject;
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
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public SubjectDTO SubjectToDTO(Subject subject) {
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

    @Override
    public Subject dtoToSubject(SubjectDTO subject) {
        if ( subject == null ) {
            return null;
        }

        Subject subject1 = new Subject();

        subject1.setIdSubject( subject.getIdSubject() );
        subject1.setNameSubject( subject.getNameSubject() );
        subject1.setCredits( subject.getCredits() );
        subject1.setState( subject.getState() );
        subject1.setFaculty( facultyDTOToFaculty( subject.getFaculty() ) );

        return subject1;
    }

    @Override
    public List<SubjectDTO> toSubjectDTOs(List<Subject> subjects) {
        if ( subjects == null ) {
            return null;
        }

        List<SubjectDTO> list = new ArrayList<SubjectDTO>( subjects.size() );
        for ( Subject subject : subjects ) {
            list.add( SubjectToDTO( subject ) );
        }

        return list;
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
}
