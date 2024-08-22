package com.innovatehub.product.service;

import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dao.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Update product.
     *
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    /**
     * Return all products.
     *
     * @return Return all products.
     */
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    /**
     * Delete product by id.
     *
     * @param productID
     */
    @Override
    public void deleteByProductId(int productID) {
        productRepository.deleteByProductId(productID);
    }

    /**
     * Save the product to the database.
     *
     * @param product
     * @return
     */
    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }
}
