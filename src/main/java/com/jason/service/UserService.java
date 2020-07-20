package com.jason.service;

import com.jason.po.User;

/**
 * @author Jason
 * @date 7/20/2020 3:57 PM
 */
public interface UserService {

    User checkUser(String username, String password);
}
