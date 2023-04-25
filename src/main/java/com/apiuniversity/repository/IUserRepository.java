package com.apiuniversity.repository;

import com.apiuniversity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository  extends IGenericRepository<User, Long> {

    @Query(
            value = "SELECT CASE WHEN EXISTS ( SELECT u FROM users u WHERE " +
                    "u.identification = :identification " +
                    "OR u.email = :email OR u.username = :username )" +
                    "THEN TRUE ELSE FALSE END" ,
            nativeQuery = true
    )
    Boolean existsUser (String identification, String email, String username);


    Optional<User> findByUsername(String username);
}
