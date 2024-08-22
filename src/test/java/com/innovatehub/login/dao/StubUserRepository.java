package com.innovatehub.login.dao;

import java.util.HashMap;
import java.util.Map;

public class StubUserRepository implements UserRepository {

    private Map<Integer, User> userRepository = new HashMap<>();

    public StubUserRepository() {
        userRepository.put(1, new User(1, "1233", 1));
    }

    @Override
    public User findUserById(int userId) {
        return userRepository.get(userId);
    }
}
