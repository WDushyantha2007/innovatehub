package com.innovatehub.product.dto;

import com.innovatehub.product.dao.Product;
import org.springframework.http.HttpStatus;

public class ProductResponse extends Product {
    private String message;

    private HttpStatus statusCode;

    public ProductResponse(Product product, String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        setProductId(product.getProductId());
        setProductName(product.getProductName());
        setProductUrl(product.getProductUrl());
        setBrand(product.getBrand());
        setDescription(product.getDescription());
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
