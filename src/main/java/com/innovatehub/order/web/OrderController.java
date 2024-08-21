package com.innovatehub.order.web;

import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dto.OrderResponse;
import com.innovatehub.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderServiceProxy;

    @Autowired
    public OrderController(OrderService orderServiceProxy) {
        this.orderServiceProxy = orderServiceProxy;
    }

    @GetMapping(value = "/order")
    public List<Order> allOrders() {
        return orderServiceProxy.findAllOrder();
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order newOrder) {
        try {
            OrderResponse orderResponse = (OrderResponse) orderServiceProxy.saveOrder(newOrder);
            return new ResponseEntity<>(orderServiceProxy.saveOrder(newOrder), orderResponse.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>(newOrder, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/order/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderServiceProxy.deleteByOrderId(orderId);
    }

    @PutMapping(value = "/order")
    public void updateOrder(@RequestBody Order order) {
        orderServiceProxy.updateOrder(order);
    }
}
