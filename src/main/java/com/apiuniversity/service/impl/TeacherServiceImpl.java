package com.apiuniversity.service.impl;

import com.apiuniversity.entity.Subject;
import com.apiuniversity.entity.Teacher;
import com.apiuniversity.entity.TeacherSubject;
import com.apiuniversity.repository.IGenericRepository;
import com.apiuniversity.repository.ITeacherRepository;
import com.apiuniversity.repository.ITeacherSubjectRepository;
import com.apiuniversity.service.ITeacherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends APICRUDImpl<Teacher, Long> implements ITeacherService {

    private final ITeacherRepository teacherRepository;
    private final ITeacherSubjectRepository teacherSubjectRepository;

    @Override
    protected IGenericRepository<Teacher, Long> getRepository() {
        return this.teacherRepository;
    }

    @Override
    @Transactional
    public Boolean saveTransaction(List<TeacherSubject> lstTeacherSubject) {

        lstTeacherSubject.forEach((TeacherSubject teacherSubject) -> {
            Teacher teacher = teacherSubject.getTeacher();
            Subject subject = teacherSubject.getSubject();
            this.teacherSubjectRepository.saveTeacherSubject(teacher.getIdTeacher(), subject.getIdSubject());
        });

        return true;
    }
}
