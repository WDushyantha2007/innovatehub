package com.innovatehub.product.dao;

import java.util.HashMap;
import java.util.List;

public class ProductStubRepository implements ProductRepository {

    private HashMap<Integer, Product> productHashMap = new HashMap<>();

    public ProductStubRepository() {
        productHashMap.put(1, new Product(1, "Test", "Test", "Test", "Test"));
        productHashMap.put(2, new Product(2, "TestTwo", "TestTwo", "TestTwo", "TestTwo"));
    }

    @Override
    public void updateProduct(Product product) {
        productHashMap.put(product.getProductId(), product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productHashMap.values().stream().toList();
    }

    @Override
    public void deleteByProductId(int productID) {
        productHashMap.remove(productID);
    }

    @Override
    public Product saveProduct(Product product) {
        productHashMap.put(product.getProductId(), product);
        return productHashMap.get(product.getProductId());
    }
}
