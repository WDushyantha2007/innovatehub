package com.innovatehub.login.service;

import com.innovatehub.login.dao.User;

public interface LoginService {
    public String findUserById(int userId, String bCryptPassword);
}
