package com.innovatehub.user.validator;

import com.innovatehub.user.dao.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserValidatorTest {

    @Test
    public void testValidMember() {
        UserValidator userValidator = new UserValidator();
        Assertions.assertEquals(true, userValidator.
                isValid(new Member(1, "Test", "Test")));
    }

    @Test
    public void testInValidMember() {
        UserValidator userValidator = new UserValidator();
        Assertions.assertEquals(false, userValidator.
                isValid(new Member(1, "", "Test")));
    }

}
