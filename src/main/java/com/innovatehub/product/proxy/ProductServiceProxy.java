package com.innovatehub.product.proxy;

import com.innovatehub.exception.APISecurityException;
import com.innovatehub.product.dao.Product;

import java.util.List;

public interface ProductServiceProxy {

    public void updateProduct(Product product, String tokenID) throws APISecurityException;

    public List<Product> findAllProduct(String tokenID) throws APISecurityException;

    public void deleteByProductId(int productID, String tokenID) throws APISecurityException;

    public Product saveProduct(Product product, String tokenID) throws APISecurityException;

}
