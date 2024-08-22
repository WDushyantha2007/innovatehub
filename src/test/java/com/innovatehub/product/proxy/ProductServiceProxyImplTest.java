package com.innovatehub.product.proxy;

import com.innovatehub.cache.APIAuthorizeCache.APICacheManager;
import com.innovatehub.exception.APISecurityException;
import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dao.ProductRepository;
import com.innovatehub.product.dao.ProductStubRepository;
import com.innovatehub.product.dto.ProductResponse;
import com.innovatehub.product.service.ProductServiceImpl;
import com.innovatehub.product.validator.ProductValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductServiceProxyImplTest {

    private ProductServiceProxyImpl productServiceProxy;
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() throws Exception {
        APICacheManager.clearCache();
        productRepository = new ProductStubRepository();
        productServiceProxy = new ProductServiceProxyImpl(new ProductServiceImpl(productRepository),
                new ProductValidator());
    }

    @Test
    public void testUpdateProductInvalidToken() {
        boolean isSecurity = false;
        try {
            productServiceProxy.updateProduct(new Product(1, "Test", "Test", "Test", "Test")
                    , "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);
    }

    @Test
    public void testUpdateProductValidToken() {
        APICacheManager.addTokenPrevilages("12", 1);
        try {
            productServiceProxy.updateProduct(new Product(1, "Test3", "Test3", "Test3", "Test"),
                    "12");
        } catch (APISecurityException e) {
        }

        Product product = productRepository.findAllProduct()
                .stream().filter(p -> p.getProductId() == 1).findFirst().get();

        Assertions.assertEquals("Test3", product.getProductName());

    }

    @Test
    public void testFindAllProductInvalidToken() {

        boolean isSecurity = false;
        try {
            productServiceProxy.findAllProduct("12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);

    }

    @Test
    public void testFindAllProductValidToken() {

        boolean isSecurity = false;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            productServiceProxy.findAllProduct("12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(false, isSecurity);
    }

    @Test
    public void testDeleteProductInvalidToken() {

        boolean isSecurity = false;
        try {
            productServiceProxy.deleteByProductId(1, "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);

    }

    @Test
    public void testDeleteProductValidToken() {
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            productServiceProxy.deleteByProductId(1, "12");
        } catch (APISecurityException e) {
        }

        List<Product> productList = productRepository.findAllProduct();
        Assertions.assertEquals(1, productList.size());
    }

    @Test
    public void testSaveProductInvalidToken() {

        boolean isSecurity = false;
        try {
            productServiceProxy.saveProduct(new Product(1, "Test", "Test", "Test", "Test"),
                    "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);
    }

    @Test
    public void testSaveProductValidTokenInvalidProduct() {

        Product productResponse = null;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            productResponse = productServiceProxy.saveProduct(new Product(1, "", "Test", "Test", "Test"), "12");
        } catch (APISecurityException e) {
        }
        Assertions.assertEquals("Invalid product", ((ProductResponse) productResponse).getMessage());
    }

    @Test
    public void testUpdateProductValidTokenValidProduct() {

        Product productResponse = null;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            productResponse = productServiceProxy.saveProduct(new Product(1, "Test", "Test", "Test", "Test"),
                    "12");
        } catch (APISecurityException e) {
        }
        Assertions.assertEquals("Product saved successfully", ((ProductResponse) productResponse).getMessage());

    }

}
