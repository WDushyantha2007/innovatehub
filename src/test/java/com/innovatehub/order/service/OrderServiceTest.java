package com.innovatehub.order.service;

import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dao.OrderStubRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderServiceTest {

    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() throws Exception {
        orderService = new OrderServiceImpl(new OrderStubRepository());
    }

    @Test
    public void testOrderUpdate() {
        orderService.updateOrder(new Order(1, "Test"));
        Order order = orderService.findAllOrder().
                stream().filter(o -> o.getOrderId() == 1).findFirst().get();

        Assertions.assertEquals("Test", order.getOrderName());
    }

    @Test
    public void testFindAllOrders() {
        List<Order> orderList = orderService.findAllOrder();
        Assertions.assertEquals(3, orderList.size());
    }

    @Test
    public void testDeleteOrder() {
        orderService.deleteByOrderId(1);
        List<Order> orderList = orderService.findAllOrder();
        Assertions.assertEquals(2, orderList.size());
    }

    @Test
    public void testSaveOrder() {
        orderService.saveOrder(new Order(4, "Fourth Order"));
        Order order = orderService.findAllOrder().
                stream().filter(o -> o.getOrderId() == 4).findFirst().get();
        Assertions.assertEquals("Fourth Order", order.getOrderName());
    }
}
