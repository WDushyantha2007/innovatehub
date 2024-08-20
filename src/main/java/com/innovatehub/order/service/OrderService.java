package com.innovatehub.order.service;

import com.innovatehub.order.dao.Order;

import java.util.List;

public interface OrderService {

    public void updateOrder(Order order);

    public List<Order> findAllOrder();

    public void deleteByOrderId(int OrderID);

    public Order saveOrder(Order order);

}
