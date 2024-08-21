package com.innovatehub.order.dto;

import com.innovatehub.order.dao.Order;
import org.springframework.http.HttpStatus;

public class OrderResponse extends Order {
    private String message;

    private HttpStatus statusCode;

    public OrderResponse(String message, Order order, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        setOrderId(order.getOrderId());
        setOrderName(order.getOrderName());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
