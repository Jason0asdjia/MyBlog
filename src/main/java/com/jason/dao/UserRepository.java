package com.jason.dao;

import com.jason.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jason
 * @date 7/20/2020 3:59 PM
 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
