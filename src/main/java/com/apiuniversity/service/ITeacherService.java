package com.apiuniversity.service;

import com.apiuniversity.entity.Teacher;
import com.apiuniversity.entity.TeacherSubject;

import java.util.List;

public interface ITeacherService extends IAPICRUD<Teacher, Long> {

    Boolean saveTransaction(List<TeacherSubject> teacherSubject);
}
