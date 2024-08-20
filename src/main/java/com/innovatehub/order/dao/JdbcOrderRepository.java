package com.innovatehub.order.dao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcOrderRepository implements OrderRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void updateOrder(Order order) {
        String sql = "update Orders set OrderName = ? where OrderID = ?";
        jdbcTemplate.update(sql, order.getOrderName(), order.getOrderId());
    }

    @Override
    public List<Order> findAllOrder() {
        List<Order> orderList = new ArrayList<>();
        String sql = "select OrderID,OrderName from  Orders";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Order order = new Order();
            order.setOrderId((Integer) row.get("OrderID"));
            order.setOrderName((String) row.get("OrderName"));
            orderList.add(order);
        }

        return orderList;
    }

    @Override
    public void deleteByOrderId(int OrderID) {
        String sql = "delete from Orders where OrderID = ?";
        jdbcTemplate.update(sql, OrderID);
    }

    @Override
    public Order saveOrder(Order order) {
        String sql = "insert into Orders(OrderName) values (?)";
        jdbcTemplate.update(sql, order.getOrderName());

        return order;
    }
}
