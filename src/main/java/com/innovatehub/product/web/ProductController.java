package com.innovatehub.product.web;

import com.innovatehub.product.dao.Product;
import com.innovatehub.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product")
    public List<Product> allProducts() {
        return productService.findAllProduct();
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        return new ResponseEntity<>(productService.saveProduct(newProduct), HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productService.deleteByProductId(productId);
    }

    @PutMapping(value = "/product")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
}
