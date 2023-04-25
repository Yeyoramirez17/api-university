package com.apiuniversity.repository;

import com.apiuniversity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends IGenericRepository<Role, Long> {

    Boolean existsByRoleName(String roleName);
    Role findByRoleName(String roleName);
}
