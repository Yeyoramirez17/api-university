package com.apiuniversity.repository;

import com.apiuniversity.entity.TeacherSubject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherSubjectRepository extends IGenericRepository<TeacherSubject, Integer>{

    @Modifying
    @Query(value = "INSERT INTO teacher_subject (id_teacher, id_subject) VALUES (:idTeacher, :idSubject);", nativeQuery = true)
    Integer saveTeacherSubject(@Param("idTeacher") Long idTeacher, @Param("idSubject") Long idSubject);
}
