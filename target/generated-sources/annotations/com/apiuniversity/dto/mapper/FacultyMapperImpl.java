package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.FacultyDTO;
import com.apiuniversity.entity.Faculty;
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
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public FacultyDTO FacultyToDTO(Faculty faculty) {
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

    @Override
    public Faculty dtoToFaculty(FacultyDTO faculty) {
        if ( faculty == null ) {
            return null;
        }

        Faculty faculty1 = new Faculty();

        faculty1.setIdFaculty( faculty.getIdFaculty() );
        faculty1.setNameFaculty( faculty.getNameFaculty() );
        faculty1.setDirection( faculty.getDirection() );
        faculty1.setPhone( faculty.getPhone() );
        faculty1.setEmail( faculty.getEmail() );

        return faculty1;
    }

    @Override
    public List<FacultyDTO> toFacultyDTOs(List<Faculty> faculties) {
        if ( faculties == null ) {
            return null;
        }

        List<FacultyDTO> list = new ArrayList<FacultyDTO>( faculties.size() );
        for ( Faculty faculty : faculties ) {
            list.add( FacultyToDTO( faculty ) );
        }

        return list;
    }
}
