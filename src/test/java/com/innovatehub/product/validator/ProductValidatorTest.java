package com.innovatehub.product.validator;

import com.innovatehub.product.dao.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductValidatorTest {

    @Test
    public void testValidProduct() {
        ProductValidator productValidator = new ProductValidator();
        Assertions.assertEquals(true,
                productValidator.isValid(new Product(1, "Test", "Test", "Test", "Test")));
    }

    @Test
    public void testInValidProduct() {
        ProductValidator productValidator = new ProductValidator();
        Assertions.assertEquals(false,
                productValidator.isValid(new Product(1, "", "Test", "Test", "Test")));
    }

}
