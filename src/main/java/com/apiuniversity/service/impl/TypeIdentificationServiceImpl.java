package com.apiuniversity.service.impl;

import com.apiuniversity.entity.TypeIdentification;
import com.apiuniversity.exception.BadRequestException;
import com.apiuniversity.repository.IGenericRepository;
import com.apiuniversity.repository.ITypeIdentificationRepository;
import com.apiuniversity.service.ITypeIdentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeIdentificationServiceImpl
        extends APICRUDImpl <TypeIdentification, Long>
        implements ITypeIdentificationService {


    private final ITypeIdentificationRepository typeIdentificationRepository;

    @Override
    protected IGenericRepository<TypeIdentification, Long> getRepository() {
        return typeIdentificationRepository;
    }

    @Override
    public TypeIdentification save(TypeIdentification typeIdentification) {
        if (typeIdentificationRepository.existsByNameIdentification(typeIdentification.getNameIdentification()))
            new BadRequestException("Type identification " + typeIdentification.getNameIdentification() + " already exists");

        return super.save(typeIdentification);
    }
}
