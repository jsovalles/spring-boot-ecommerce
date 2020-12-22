package com.ecommerce.facade.dto;

import com.ecommerce.dao.entity.Address;
import com.ecommerce.dao.entity.Customer;
import com.ecommerce.dao.entity.Order;
import com.ecommerce.dao.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
