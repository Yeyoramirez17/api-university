package com.apiuniversity.service.impl;

import com.apiuniversity.entity.Role;
import com.apiuniversity.entity.User;
import com.apiuniversity.exception.BadRequestException;
import com.apiuniversity.repository.IGenericRepository;
import com.apiuniversity.repository.IRoleRepository;
import com.apiuniversity.repository.IUserRepository;
import com.apiuniversity.service.IRoleService;
import com.apiuniversity.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl extends APICRUDImpl<User, Long>  implements IUserService {

    private static final String USER_DEFAULT = "User";
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    protected IGenericRepository<User, Long> getRepository() {
        return this.userRepository;
    }

    @Override
    public User save(User user) {
        boolean exists = this.userRepository.existsUser
                (user.getIdentification(), user.getEmail(), user.getUsername());

        if (exists) {
            throw new BadRequestException
                    ("User already exists with email " +
                            user.getEmail() + " and username " + user.getUsername());
        }

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            List<Role> roles = new ArrayList<Role>();
            Role role = roleRepository.findByRoleName(USER_DEFAULT);
            roles.add(role);
            user.setRoles(roles);
        }
        return super.save(user);
    }
}
