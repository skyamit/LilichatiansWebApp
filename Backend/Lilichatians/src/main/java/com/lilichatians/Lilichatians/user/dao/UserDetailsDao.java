package com.lilichatians.Lilichatians.user.dao;

import com.lilichatians.Lilichatians.common.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsDao extends JpaRepository<UserDetails, Long> {
}
