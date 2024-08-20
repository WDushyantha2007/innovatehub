package com.innovatehub.product.dao;

import java.util.List;

public interface ProductRepository {

    public void updateProduct(Product product);

    public List<Product> findAllProduct();

    public void deleteByProductId(int productID);

    public Product saveProduct(Product product);

}
