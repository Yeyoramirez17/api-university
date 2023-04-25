package com.apiuniversity.service.impl;

import com.apiuniversity.entity.Role;
import com.apiuniversity.exception.BadRequestException;
import com.apiuniversity.repository.IGenericRepository;
import com.apiuniversity.repository.IRoleRepository;
import com.apiuniversity.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends APICRUDImpl<Role, Long> implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    protected IGenericRepository<Role, Long> getRepository() {
        return roleRepository;
    }

    @Override
    public Role save(Role role) {
        if (roleRepository.existsByRoleName(role.getRoleName())) {
            throw new BadRequestException("Role " + role.getRoleName() + " already exists");
        }
        return super.save(role);
    }

}
