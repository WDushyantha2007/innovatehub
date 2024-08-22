package com.innovatehub.order.proxy;

import com.innovatehub.cache.APIAuthorizeCache.APICacheManager;
import com.innovatehub.exception.APISecurityException;
import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dao.OrderRepository;
import com.innovatehub.order.dao.OrderStubRepository;
import com.innovatehub.order.dto.OrderResponse;
import com.innovatehub.order.service.OrderServiceImpl;
import com.innovatehub.order.validator.OrderValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderProxyServiceProxyTest {

    private OrderServiceProxyImpl orderServiceProxy;
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() throws Exception {
        APICacheManager.clearCache();
        orderRepository = new OrderStubRepository();
        orderServiceProxy = new OrderServiceProxyImpl(
                new OrderServiceImpl(orderRepository), new OrderValidator());

    }

    @Test
    public void testUpdateOrderInvalidToken() {
        boolean isSecurity = false;
        try {
            orderServiceProxy.updateOrder(new Order(), "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);
    }

    @Test
    public void testUpdateOrderValidToken() {
        APICacheManager.addTokenPrevilages("12", 1);
        try {
            orderServiceProxy.updateOrder(new Order(1, "Test"), "12");
        } catch (APISecurityException e) {
        }

        Order order = orderRepository.findAllOrder()
                .stream().filter(o -> o.getOrderId() == 1).findFirst().get();

        Assertions.assertEquals("Test", order.getOrderName());

    }

    @Test
    public void testFindAllOrderInvalidToken() {

        boolean isSecurity = false;
        try {
            orderServiceProxy.findAllOrder("12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);

    }

    @Test
    public void testFindAllOrderValidToken() {

        boolean isSecurity = false;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            orderServiceProxy.findAllOrder("12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(false, isSecurity);
    }

    @Test
    public void testDeleteOrderInvalidToken() {

        boolean isSecurity = false;
        try {
            orderServiceProxy.deleteByOrderId(1, "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);

    }

    @Test
    public void testDeleteOrderValidToken() {
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            orderServiceProxy.deleteByOrderId(1, "12");
        } catch (APISecurityException e) {
        }

        List<Order> orderList = orderRepository.findAllOrder();
        Assertions.assertEquals(2, orderList.size());
    }

    @Test
    public void testSaveOrderInvalidToken() {

        boolean isSecurity = false;
        try {
            orderServiceProxy.saveOrder(new Order(1, "Test"), "12");
        } catch (APISecurityException e) {
            isSecurity = true;
        }
        Assertions.assertEquals(true, isSecurity);
    }

    @Test
    public void testSaveOrderValidTokenInvalidOrder() {

        Order orderResponse = null;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            orderResponse = orderServiceProxy.saveOrder(new Order(1, ""), "12");
        } catch (APISecurityException e) {
        }
        Assertions.assertEquals("Invalid  order request", ((OrderResponse) orderResponse).getMessage());
    }

    @Test
    public void testUpdateOrderValidTokenValidOrder() {

        Order orderResponse = null;
        try {
            APICacheManager.addTokenPrevilages("12", 1);
            orderResponse = orderServiceProxy.saveOrder(new Order(4, "Test44"), "12");
        } catch (APISecurityException e) {
        }
        Assertions.assertEquals("Order saved successfully", ((OrderResponse) orderResponse).getMessage());

    }

}
