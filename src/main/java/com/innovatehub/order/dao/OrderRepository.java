package com.innovatehub.order.dao;

import java.util.List;

public interface OrderRepository {

    public void updateOrder(Order order);

    public List<Order> findAllOrder();

    public void deleteByOrderId(int OrderID);

    public Order saveOrder(Order order);

}
