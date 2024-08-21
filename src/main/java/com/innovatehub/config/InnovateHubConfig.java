package com.innovatehub.config;

import com.innovatehub.login.dao.UserJdbcRepository;
import com.innovatehub.login.dao.UserRepository;
import com.innovatehub.login.service.LoginService;
import com.innovatehub.login.service.LoginServiceImpl;
import com.innovatehub.order.dao.JdbcOrderRepository;
import com.innovatehub.order.dao.OrderRepository;
import com.innovatehub.order.proxy.OrderServiceProxyImpl;
import com.innovatehub.order.service.OrderService;
import com.innovatehub.order.service.OrderServiceImpl;
import com.innovatehub.order.validator.OrderValidator;
import com.innovatehub.product.dao.JdbcProductRepository;
import com.innovatehub.product.dao.ProductRepository;
import com.innovatehub.product.proxy.ProductServiceProxyImpl;
import com.innovatehub.product.service.ProductService;
import com.innovatehub.product.service.ProductServiceImpl;
import com.innovatehub.product.validator.ProductValidator;
import com.innovatehub.user.dao.JdbcMemberRepository;
import com.innovatehub.user.dao.MemberRepository;
import com.innovatehub.user.proxy.UserServiceProxyImpl;
import com.innovatehub.user.service.UserService;
import com.innovatehub.user.service.UserServiceImpl;
import com.innovatehub.user.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("orderServiceProxy")
    public OrderService orderServiceProxy() {
        return new OrderServiceProxyImpl(orderService(), orderValidator());
    }

    @Bean
    @Qualifier("productServiceProxy")
    public ProductService productServiceProxy() {
        return new ProductServiceProxyImpl(productService(), productValidator());
    }

    @Bean
    @Qualifier("userServiceProxy")
    public UserService userServiceProxy() {
        return new UserServiceProxyImpl(userService(), userValidator());
    }

    @Bean
    @Qualifier("productService")
    public ProductService productService() {
        return new ProductServiceImpl(productRepository());
    }

    @Bean
    @Qualifier("orderService")
    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository());
    }

    @Bean
    @Qualifier("userService")
    public UserService userService() {
        return new UserServiceImpl(memberRepository());
    }

    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl(userRepository());
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

    @Bean
    public OrderValidator orderValidator() {
        return new OrderValidator();
    }

    @Bean
    public UserRepository userRepository() {
        UserRepository userRepository = new UserJdbcRepository(jdbcTemplate);
        return userRepository;
    }

    @Bean
    public ProductValidator productValidator() {
        return new ProductValidator();
    }

    @Bean
    public UserValidator userValidator() {
        return new UserValidator();
    }
}
