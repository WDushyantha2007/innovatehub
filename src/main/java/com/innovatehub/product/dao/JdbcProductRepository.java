package com.innovatehub.product.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcProductRepository implements ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Update the given product.
     *
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        String sql = "update product set ProductName = ?, Brand = ?, Description = ?, ProductUrl = ? where ProductID = ?";
        jdbcTemplate.update(sql, product.getProductName(), product.getBrand(),
                product.getDescription(), product.getProductUrl(), product.getProductId());
    }

    /**
     * Return all products
     *
     * @return all products.
     */
    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = new ArrayList<>();
        String sql = "select ProductID, ProductName, Brand, Description, ProductUrl from  product";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Product product = new Product();
            product.setProductId((Integer) row.get("ProductID"));
            product.setProductName((String) row.get("ProductName"));
            product.setBrand((String) row.get("Brand"));
            product.setDescription((String) row.get("Description"));
            product.setProductUrl((String) row.get("ProductUrl"));
            productList.add(product);
        }

        return productList;
    }

    /**
     * Delete the given product.
     *
     * @param productID
     */
    @Override
    public void deleteByProductId(int productID) {
        String sql = "delete from product where ProductID = ?";
        jdbcTemplate.update(sql, productID);
    }

    /**
     * Save the product to the database.
     *
     * @param product
     * @return given product.
     */
    @Override
    public Product saveProduct(Product product) {
        String sql = "insert into product(ProductName, Brand, Description, ProductUrl) values (?,?,?,?)";
        jdbcTemplate.update(sql, product.getProductName(), product.getBrand(), product.getDescription(),
                product.getProductUrl());

        return product;
    }
}
