package com.apiuniversity.repository;

import com.apiuniversity.entity.Faculty;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacultyRepository extends IGenericRepository<Faculty, Long> {
}
