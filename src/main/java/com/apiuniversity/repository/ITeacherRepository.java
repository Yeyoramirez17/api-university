package com.apiuniversity.repository;

import com.apiuniversity.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends IGenericRepository<Teacher, Long> {
}
