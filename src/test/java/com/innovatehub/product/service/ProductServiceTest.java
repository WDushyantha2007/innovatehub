package com.innovatehub.product.service;

import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dao.ProductStubRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductServiceTest {

    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() throws Exception {
        productService = new ProductServiceImpl(new ProductStubRepository());
    }

    @Test
    public void testOrderUpdate() {
        productService.updateProduct(new Product(1, "Test1", "Test1", "Test1", "Test1"));
        Product product = productService.findAllProduct().
                stream().filter(p -> p.getProductId() == 1).findFirst().get();

        Assertions.assertEquals("Test1", product.getProductName());
        Assertions.assertEquals("Test1", product.getBrand());
        Assertions.assertEquals("Test1", product.getDescription());
        Assertions.assertEquals("Test1", product.getProductUrl());
    }

    @Test
    public void testFindAllOrders() {
        List<Product> productList = productService.findAllProduct();
        Assertions.assertEquals(2, productList.size());
    }

    @Test
    public void testDeleteOrder() {
        productService.deleteByProductId(1);
        List<Product> productList = productService.findAllProduct();
        Assertions.assertEquals(1, productList.size());
    }

    @Test
    public void testSaveOrder() {
        productService.saveProduct(new Product(3, "Test3", "Test3", "Test3", "Test3"));
        Product product = productService.findAllProduct().
                stream().filter(p -> p.getProductId() == 3).findFirst().get();
        Assertions.assertEquals("Test3", product.getProductName());
    }
}
