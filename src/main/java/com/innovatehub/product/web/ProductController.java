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

    /**
     * Return all products with 200 status.
     * If token is invalid return 401.
     *
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @GetMapping(value = "/product")
    public List<Product> allProducts(@RequestHeader("tokenID") String tokenID) throws APISecurityException {
        return productServiceProxy.findAllProduct(tokenID);
    }

    /**
     * Save the product. If security error comes return 401.
     * If product is invalid return 400 with given product.
     * If product is valid return 200 with valid product.
     * If security token is invalid return 401 error.
     *
     * @param newProduct
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
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

    /**
     * Delete the provided product and return 200 status code.
     * If token is invalid return 401.
     *
     * @param productId
     * @param tokenID
     * @throws APISecurityException
     */
    @DeleteMapping(value = "/product/{productId}")
    public void deleteProduct(@PathVariable int productId, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        productServiceProxy.deleteByProductId(productId, tokenID);
    }

    /**
     * Update the product and return 200 status code.
     * If token is invalid return 401.
     *
     * @param product
     * @param tokenID
     * @throws APISecurityException
     */
    @PutMapping(value = "/product")
    public void updateProduct(@RequestBody Product product, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        productServiceProxy.updateProduct(product, tokenID);
    }

    /**
     * If security error comes return 401.
     *
     * @param ex
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(APISecurityException.class)
    public void handleUnAuthorized(APISecurityException ex) {
    }


}
