package com.apiuniversity.repository;

import com.apiuniversity.entity.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends IGenericRepository<Subject, Long> {
}
