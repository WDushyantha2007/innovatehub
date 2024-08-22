package com.innovatehub.product.proxy;

import com.innovatehub.cache.APIAuthorizeCache.APICacheManager;
import com.innovatehub.exception.APISecurityException;
import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dto.ProductResponse;
import com.innovatehub.product.service.ProductService;
import com.innovatehub.product.validator.ProductValidator;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ProductServiceProxyImpl implements ProductServiceProxy {

    private ProductService productService;
    private ProductValidator productValidator;

    public ProductServiceProxyImpl(ProductService productService, ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes update product.
     *
     * @param product
     * @param tokenID
     * @throws APISecurityException
     */
    @Override
    public void updateProduct(Product product, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "product")) {
            throw new APISecurityException("Unauthorized operation");
        }

        productService.updateProduct(product);
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes return all products.
     *
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @Override
    public List<Product> findAllProduct(String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "product")) {
            throw new APISecurityException("Unauthorized operation");
        }

        return productService.findAllProduct();
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes delete the product.
     *
     * @param productID
     * @param tokenID
     * @throws APISecurityException
     */
    @Override
    public void deleteByProductId(int productID, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "product")) {
            throw new APISecurityException("Unauthorized operation");
        }

        productService.deleteByProductId(productID);
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes validate the product.
     * If valid then save the product.
     *
     * @param product
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @Override
    public Product saveProduct(Product product, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "product")) {
            throw new APISecurityException("Unauthorized operation");
        }

        if (!productValidator.isValid(product)) {
            return new ProductResponse(product, "Invalid product", HttpStatus.BAD_REQUEST);
        }
        productService.saveProduct(product);
        return new ProductResponse(product, "Product saved successfully", HttpStatus.OK);
    }
}
