package com.innovatehub.order.proxy;

import com.innovatehub.cache.APIAuthorizeCache.APICacheManager;
import com.innovatehub.exception.APISecurityException;
import com.innovatehub.order.dao.Order;
import com.innovatehub.order.dto.OrderResponse;
import com.innovatehub.order.service.OrderService;
import com.innovatehub.order.validator.OrderValidator;
import org.springframework.http.HttpStatus;

import java.util.List;

public class OrderServiceProxyImpl implements OrderProxyService {

    private OrderService orderService;
    private OrderValidator orderValidator;

    public OrderServiceProxyImpl(OrderService orderService, OrderValidator orderValidator) {
        this.orderService = orderService;
        this.orderValidator = orderValidator;
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes then update order
     *
     * @param order
     * @param tokenID
     * @throws APISecurityException
     */

    @Override
    public void updateOrder(Order order, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "order")) {
            throw new APISecurityException("Unauthorized operation");
        }

        orderService.updateOrder(order);
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes return all order.
     *
     * @param tokenID
     * @return
     * @throws APISecurityException
     */

    @Override
    public List<Order> findAllOrder(String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "order")) {
            throw new APISecurityException("Unauthorized operation");
        }

        return orderService.findAllOrder();
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes  delete the order.
     *
     * @param OrderID
     * @param tokenID
     * @throws APISecurityException
     */

    @Override
    public void deleteByOrderId(int OrderID, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "order")) {
            throw new APISecurityException("Unauthorized operation");
        }

        orderService.deleteByOrderId(OrderID);
    }

    /**
     * Check user has valid security token which has access to the api.
     * If yes validate the order.
     * If valid then save the order.
     *
     * @param order
     * @param tokenID
     * @return
     * @throws APISecurityException
     */

    @Override
    public Order saveOrder(Order order, String tokenID) throws APISecurityException {

        if (!APICacheManager.findRoleHasAPIAcesss(tokenID, "order")) {
            throw new APISecurityException("Unauthorized operation");
        }

        if (!orderValidator.isValid(order)) {
            return new OrderResponse("Invalid  order request", order, HttpStatus.BAD_REQUEST);
        }
        orderService.saveOrder(order);
        return new OrderResponse("Order saved successfully", order, HttpStatus.OK);
    }
}
