package com.innovatehub.config;

import com.innovatehub.order.dao.JdbcOrderRepository;
import com.innovatehub.order.dao.OrderRepository;
import com.innovatehub.order.service.OrderService;
import com.innovatehub.order.service.OrderServiceImpl;
import com.innovatehub.product.dao.JdbcProductRepository;
import com.innovatehub.product.dao.ProductRepository;
import com.innovatehub.product.service.ProductService;
import com.innovatehub.product.service.ProductServiceImpl;
import com.innovatehub.user.dao.JdbcMemberRepository;
import com.innovatehub.user.dao.MemberRepository;
import com.innovatehub.user.service.UserService;
import com.innovatehub.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class InnovateHubConfig {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public InnovateHubConfig(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(productRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(memberRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        ProductRepository productRepository = new JdbcProductRepository(jdbcTemplate);
        return productRepository;
    }

    @Bean
    public OrderRepository orderRepository() {
        OrderRepository orderRepository = new JdbcOrderRepository(jdbcTemplate);
        return orderRepository;
    }

    @Bean
    public MemberRepository memberRepository() {
        MemberRepository memberRepository = new JdbcMemberRepository(jdbcTemplate);
        return memberRepository;
    }

}
