package com.innovatehub.order.service;

import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dao.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Update the order.
     *
     * @param order
     */
    @Override
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    /**
     * Return all orders.
     *
     * @return all orders.
     */
    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAllOrder();
    }

    /**
     * Delete order by id.
     *
     * @param OrderID
     */
    @Override
    public void deleteByOrderId(int OrderID) {
        orderRepository.deleteByOrderId(OrderID);
    }

    /**
     * Persist the order
     *
     * @param order
     * @return given order.
     */
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }
}
