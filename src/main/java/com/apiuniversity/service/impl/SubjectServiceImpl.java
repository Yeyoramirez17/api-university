package com.apiuniversity.service.impl;

import com.apiuniversity.entity.Subject;
import com.apiuniversity.repository.ISubjectRepository;
import com.apiuniversity.repository.IGenericRepository;
import com.apiuniversity.service.ISubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl extends APICRUDImpl<Subject, Long> implements ISubjectService {

    private final ISubjectRepository subjectRepository;

    @Override
    protected IGenericRepository<Subject, Long> getRepository() {
        return this.subjectRepository;
    }
}
