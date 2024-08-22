package com.innovatehub.product.web;

import com.innovatehub.exception.APISecurityException;
import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dto.ProductResponse;
import com.innovatehub.product.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductServiceProxy productServiceProxy;

    @Autowired
    public ProductController(ProductServiceProxy productServiceProxy) throws APISecurityException {
        this.productServiceProxy = productServiceProxy;
    }

    @GetMapping(value = "/product")
    public List<Product> allProducts(@RequestHeader("tokenID") String tokenID) throws APISecurityException {
        return productServiceProxy.findAllProduct(tokenID);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        try {
            ProductResponse productResponse = (ProductResponse) productServiceProxy.saveProduct(newProduct, tokenID);
            return new ResponseEntity<>(productResponse, productResponse.getStatusCode());
        } catch (APISecurityException e) {
            throw new APISecurityException("Unauthorized operation");
        } catch (Exception e) {
            return new ResponseEntity<>(newProduct, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/product/{productId}")
    public void deleteProduct(@PathVariable int productId, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        productServiceProxy.deleteByProductId(productId, tokenID);
    }

    @PutMapping(value = "/product")
    public void updateProduct(@RequestBody Product product, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        productServiceProxy.updateProduct(product, tokenID);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(APISecurityException.class)
    public void handleUnAuthorized(APISecurityException ex) {
    }


}
