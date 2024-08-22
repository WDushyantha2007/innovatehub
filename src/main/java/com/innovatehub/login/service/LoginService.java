package com.innovatehub.login.service;

public interface LoginService {
    public String findUserById(int userId, String bCryptPassword);
}
