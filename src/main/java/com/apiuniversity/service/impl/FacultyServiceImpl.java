package com.apiuniversity.service.impl;

import com.apiuniversity.entity.Faculty;
import com.apiuniversity.repository.IGenericRepository;
import com.apiuniversity.repository.IFacultyRepository;
import com.apiuniversity.service.IFacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl extends APICRUDImpl<Faculty, Long> implements IFacultyService {

    private final IFacultyRepository FacultyRepository;

    @Override
    protected IGenericRepository<Faculty, Long> getRepository() {
        return this.FacultyRepository;
    }
}
