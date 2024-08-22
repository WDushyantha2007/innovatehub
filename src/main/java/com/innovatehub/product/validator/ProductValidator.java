package com.innovatehub.product.validator;

import ch.qos.logback.core.util.StringUtil;
import com.innovatehub.product.dao.Product;

public class ProductValidator {

    public ProductValidator() {

    }

    /**
     * Check product is valid
     *
     * @param product
     * @return product is valid or not.
     */
    public boolean isValid(Product product) {
        if (StringUtil.isNullOrEmpty(product.getProductName())) {
            return false;
        }
        return true;
    }
}
