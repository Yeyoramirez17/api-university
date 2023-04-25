package com.apiuniversity.dto.mapper;

import com.apiuniversity.dto.TypeIdentificationDTO;
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
public class TypeIdentificationMapperImpl implements TypeIdentificationMapper {

    @Override
    public TypeIdentificationDTO typeIdentificationToDTO(TypeIdentification typeIdentification) {
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

    @Override
    public TypeIdentification dtoToTypeIdentification(TypeIdentificationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TypeIdentification typeIdentification = new TypeIdentification();

        typeIdentification.setIdTypeIdentification( dto.getIdTypeIdentification() );
        typeIdentification.setNameIdentification( dto.getNameIdentification() );
        typeIdentification.setDescription( dto.getDescription() );
        typeIdentification.setState( dto.getState() );

        return typeIdentification;
    }

    @Override
    public List<TypeIdentificationDTO> toTypeIdentificationDTO(List<TypeIdentification> typeIdentifications) {
        if ( typeIdentifications == null ) {
            return null;
        }

        List<TypeIdentificationDTO> list = new ArrayList<TypeIdentificationDTO>( typeIdentifications.size() );
        for ( TypeIdentification typeIdentification : typeIdentifications ) {
            list.add( typeIdentificationToDTO( typeIdentification ) );
        }

        return list;
    }
}
