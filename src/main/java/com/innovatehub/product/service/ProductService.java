package com.innovatehub.product.service;

import com.innovatehub.product.dao.Product;

import java.util.List;

public interface ProductService {

    public void updateProduct(Product product);

    public List<Product> findAllProduct();

    public void deleteByProductId(int productID);

    public Product saveProduct(Product product);

}
