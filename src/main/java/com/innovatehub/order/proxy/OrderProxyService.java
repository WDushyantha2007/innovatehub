package com.innovatehub.order.proxy;

import com.innovatehub.exception.APISecurityException;
import com.innovatehub.order.dao.Order;

import java.util.List;

public interface OrderProxyService {

    public void updateOrder(Order order, String tokenID)throws APISecurityException;

    public List<Order> findAllOrder(String tokenID) throws APISecurityException;

    public void deleteByOrderId(int OrderID, String tokenID) throws APISecurityException;

    public Order saveOrder(Order order, String tokenID) throws APISecurityException;

}
