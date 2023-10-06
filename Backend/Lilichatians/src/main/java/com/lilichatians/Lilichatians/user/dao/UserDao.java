package com.lilichatians.Lilichatians.user.dao;

import com.lilichatians.Lilichatians.common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Long> {
    User save(User user);
}
