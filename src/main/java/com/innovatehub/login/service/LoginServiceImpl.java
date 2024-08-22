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

    /**
     * Find user with given user id. Match user password with provided password.
     * If match new token generated and added to role cache and return new token
     * Else return empty token.
     *
     * @param userId         user id
     * @param bCryptPassword user bcrypt password
     * @return security token
     */
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
