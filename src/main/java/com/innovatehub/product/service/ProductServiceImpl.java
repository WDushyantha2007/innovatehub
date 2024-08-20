package com.innovatehub.product.service;

import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dao.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public void deleteByProductId(int productID) {
        productRepository.deleteByProductId(productID);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }
}
