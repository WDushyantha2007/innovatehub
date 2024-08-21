package com.innovatehub.product.web;

import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dto.ProductResponse;
import com.innovatehub.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productServiceProxy;

    @Autowired
    public ProductController(ProductService productServiceProxy) {
        this.productServiceProxy = productServiceProxy;
    }

    @GetMapping(value = "/product")
    public List<Product> allProducts() {
        return productServiceProxy.findAllProduct();
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        try {
            ProductResponse productResponse = (ProductResponse) productServiceProxy.saveProduct(newProduct);
            return new ResponseEntity<>(productServiceProxy.saveProduct(productResponse), productResponse.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>(newProduct, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/product/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productServiceProxy.deleteByProductId(productId);
    }

    @PutMapping(value = "/product")
    public void updateProduct(@RequestBody Product product) {
        productServiceProxy.updateProduct(product);
    }
}
