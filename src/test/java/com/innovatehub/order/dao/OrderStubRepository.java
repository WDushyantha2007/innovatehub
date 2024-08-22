package com.innovatehub.order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderStubRepository implements OrderRepository {

    public HashMap<Integer, Order> orderHashMap = new HashMap<>();

    public OrderStubRepository() {
        orderHashMap.put(1, new Order(1, "FirstOrder"));
        orderHashMap.put(2, new Order(2, "SecondOrder"));
        orderHashMap.put(3, new Order(3, "ThirdOrder"));
    }


    @Override
    public void updateOrder(Order order) {
        orderHashMap.put(order.getOrderId(), order);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderHashMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteByOrderId(int OrderID) {
        orderHashMap.remove(OrderID);
    }

    @Override
    public Order saveOrder(Order order) {
        orderHashMap.put(order.getOrderId(), order);
        return orderHashMap.get(order.getOrderId());
    }
}
