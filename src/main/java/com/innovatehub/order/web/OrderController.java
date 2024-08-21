package com.innovatehub.order.web;

import com.innovatehub.exception.APISecurityException;
import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dto.OrderResponse;
import com.innovatehub.order.proxy.OrderProxyService;
import com.innovatehub.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderProxyService orderServiceProxy;

    @Autowired
    public OrderController(OrderProxyService orderServiceProxy) {
        this.orderServiceProxy = orderServiceProxy;
    }

    @GetMapping(value = "/order")
    public List<Order> allOrders(@RequestHeader("tokenID") String tokenID)throws APISecurityException {
        return orderServiceProxy.findAllOrder(tokenID);
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order newOrder, @RequestHeader("tokenID") String tokenID)throws APISecurityException {
        try {
            OrderResponse orderResponse = (OrderResponse) orderServiceProxy.saveOrder(newOrder, tokenID);
            return new ResponseEntity<>(orderResponse, orderResponse.getStatusCode());
        } catch (APISecurityException e) {
            throw new APISecurityException("Unauthorized operation");
        } catch (Exception e) {
            return new ResponseEntity<>(newOrder, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/order/{orderId}")
    public void deleteOrder(@PathVariable int orderId, @RequestHeader("tokenID") String tokenID)throws APISecurityException {
        orderServiceProxy.deleteByOrderId(orderId, tokenID);
    }

    @PutMapping(value = "/order")
    public void updateOrder(@RequestBody Order order, @RequestHeader("tokenID") String tokenID)throws APISecurityException {
        orderServiceProxy.updateOrder(order, tokenID);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(APISecurityException.class)
    public void handleUnAuthorized(APISecurityException ex) {
    }
}
