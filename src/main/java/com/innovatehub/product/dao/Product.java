package com.innovatehub.product.dao;

public class Product {

    private int productId;

    private String productName;

    private String brand;

    private String description;

    private String productUrl;

    public Product() {

    }

    public Product(int productId, String productName, String brand, String description, String productUrl) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.description = description;
        this.productUrl = productUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
