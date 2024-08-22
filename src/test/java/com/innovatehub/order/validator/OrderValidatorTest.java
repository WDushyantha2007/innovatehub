package com.innovatehub.order.validator;

import com.innovatehub.order.dao.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderValidatorTest {

    @Test
    public void testValidOrder() {
        OrderValidator orderValidator = new OrderValidator();
        Assertions.assertEquals(true, orderValidator.isValid(new Order(1, "Test")));
    }

    @Test
    public void testInValidOrder() {
        OrderValidator orderValidator = new OrderValidator();
        Assertions.assertEquals(false, orderValidator.isValid(new Order(1, "")));
    }
}
