package com.innovatehub.order.validator;

import ch.qos.logback.core.util.StringUtil;
import com.innovatehub.order.dao.Order;

public class OrderValidator {

    public OrderValidator() {

    }

    /**
     * Validate the order.
     *
     * @param order
     * @return order is valid or not.
     */
    public boolean isValid(Order order) {
        if (StringUtil.isNullOrEmpty(order.getOrderName())) {
            return false;
        }
        return true;
    }

}
