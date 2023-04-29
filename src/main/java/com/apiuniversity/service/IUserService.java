package com.apiuniversity.service;

import com.apiuniversity.entity.User;

import java.util.Optional;

public interface IUserService extends IAPICRUD<User, Long>{

    public Optional<User> findByUsername(String username);
}
