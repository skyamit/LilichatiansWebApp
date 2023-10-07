package com.lilichatians.Lilichatians.user.dao;

import com.lilichatians.Lilichatians.common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Long> {
    User save(User user);
    @Query(value = " Select * from user where email = :email and password = :password and code = :code and is_active is false" , nativeQuery = true)
    User fetchByEmailPasswordCode(String email, String password, String code);
}
