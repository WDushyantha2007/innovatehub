package com.innovatehub.order.web;

import com.innovatehub.order.dao.Order;
import com.innovatehub.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order")
    public List<Order> allOrders() {
        return orderService.findAllOrder();
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order newOrder) {
        return new ResponseEntity<>(orderService.saveOrder(newOrder), HttpStatus.OK);
    }

    @DeleteMapping(value = "/order/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteByOrderId(orderId);
    }

    @PutMapping(value = "/order")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }
}
