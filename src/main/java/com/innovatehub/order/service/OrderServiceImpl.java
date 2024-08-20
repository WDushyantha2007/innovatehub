package com.innovatehub.order.service;

import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dao.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAllOrder();
    }

    @Override
    public void deleteByOrderId(int OrderID) {
        orderRepository.deleteByOrderId(OrderID);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }
}
