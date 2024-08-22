package com.innovatehub.login.service;

import com.innovatehub.login.dao.StubUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginServiceTest {

    private LoginServiceImpl loginService;

    @BeforeEach
    public void setUp() throws Exception {
        loginService = new LoginServiceImpl(new StubUserRepository());
    }

    @Test
    public void testFindUserById() {
        String uuid = loginService.findUserById(1, "1233");
        Assertions.assertNotNull(uuid);
    }

    @Test
    public void testFindUserByIdDoNotExists() {
        String uuid = loginService.findUserById(2, "1233");
        Assertions.assertEquals("", uuid);
    }
}
