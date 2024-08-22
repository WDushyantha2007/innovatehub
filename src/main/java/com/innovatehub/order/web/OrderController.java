package com.innovatehub.order.web;

import com.innovatehub.exception.APISecurityException;
import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dto.OrderResponse;
import com.innovatehub.order.proxy.OrderProxyService;
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

    /**
     * Return all orders with 200 status.
     * If token is invalid return 401.
     *
     * @param tokenID
     * @return
     * @throws APISecurityException
     */
    @GetMapping(value = "/order")
    public List<Order> allOrders(@RequestHeader("tokenID") String tokenID) throws APISecurityException {
        return orderServiceProxy.findAllOrder(tokenID);
    }

    /**
     * Save the order. If security error comes return 401.
     * If order is invalid return 400 with given order.
     * If order is valid return 200 with valid order.
     * If security token is invalid return 401 error.
     *
     * @param newOrder
     * @param tokenID
     * @return saved order or in case of error given order with error status.
     * @throws APISecurityException
     */
    @PostMapping(value = "/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order newOrder, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        try {
            OrderResponse orderResponse = (OrderResponse) orderServiceProxy.saveOrder(newOrder, tokenID);
            return new ResponseEntity<>(orderResponse, orderResponse.getStatusCode());
        } catch (APISecurityException e) {
            throw new APISecurityException("Unauthorized operation");
        } catch (Exception e) {
            return new ResponseEntity<>(newOrder, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete the given order with 200 status.
     * If token is invalid return 401.
     *
     * @param orderId
     * @param tokenID
     * @throws APISecurityException
     */
    @DeleteMapping(value = "/order/{orderId}")
    public void deleteOrder(@PathVariable int orderId, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        orderServiceProxy.deleteByOrderId(orderId, tokenID);
    }

    /**
     * Update the given order with 200 status.
     * If token is invalid return 401.
     *
     * @param order
     * @param tokenID
     * @throws APISecurityException
     */
    @PutMapping(value = "/order")
    public void updateOrder(@RequestBody Order order, @RequestHeader("tokenID") String tokenID) throws APISecurityException {
        orderServiceProxy.updateOrder(order, tokenID);
    }

    /**
     * If security error comes return 401.
     *
     * @param ex
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(APISecurityException.class)
    public void handleUnAuthorized(APISecurityException ex) {
    }
}
