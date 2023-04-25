package com.apiuniversity.repository;

import com.apiuniversity.entity.TypeIdentification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeIdentificationRepository extends IGenericRepository<TypeIdentification, Long> {

    Boolean existsByNameIdentification(String name);

}
