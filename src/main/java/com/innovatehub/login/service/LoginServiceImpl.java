package com.innovatehub.login.service;

import com.innovatehub.cache.APIAuthorizeCache.APICacheManager;
import com.innovatehub.login.dao.User;
import com.innovatehub.login.dao.UserRepository;

import java.util.UUID;

public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String findUserById(int userId, String bCryptPassword) {
        User user = userRepository.findUserById(userId);
        String uuid = "";
        if (user != null && bCryptPassword.equals(user.getbCryptPassword())) {
            uuid = UUID.randomUUID().toString();
            APICacheManager.addTokenPrevilages(uuid, user.getUserId());
        }
        return uuid;
    }
}
