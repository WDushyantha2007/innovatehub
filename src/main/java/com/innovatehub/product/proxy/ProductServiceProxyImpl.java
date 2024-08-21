package com.innovatehub.product.proxy;

import com.innovatehub.product.dao.Product;
import com.innovatehub.product.dto.ProductResponse;
import com.innovatehub.product.service.ProductService;
import com.innovatehub.product.validator.ProductValidator;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ProductServiceProxyImpl implements ProductService {

    private ProductService productService;
    private ProductValidator productValidator;

    public ProductServiceProxyImpl(ProductService productService, ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
    }

    @Override
    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    @Override
    public void deleteByProductId(int productID) {
        productService.deleteByProductId(productID);
    }

    @Override
    public Product saveProduct(Product product) {
        if (!productValidator.isValid(product)) {
            return new ProductResponse(product, "Invalid product", HttpStatus.BAD_REQUEST);
        }
        productService.saveProduct(product);
        return new ProductResponse(product, "Product saved successfully", HttpStatus.OK);
    }
}
