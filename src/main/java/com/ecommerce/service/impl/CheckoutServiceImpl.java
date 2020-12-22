package com.ecommerce.service.impl;

import com.ecommerce.dao.ICustomerRepository;
import com.ecommerce.dao.entity.Customer;
import com.ecommerce.dao.entity.Order;
import com.ecommerce.dao.entity.OrderItem;
import com.ecommerce.facade.dto.Purchase;
import com.ecommerce.facade.dto.PurchaseResponse;
import com.ecommerce.service.ICheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements ICheckoutService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve order from dto
        Order order = purchase.getOrder();

        //generating a random orderTrackingNumber
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(orderItem -> order.add(orderItem));

        //populate order with billing and shipping address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save it to the db
        customerRepository.save(customer);

        //return the response
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        //random UUID number
        return UUID.randomUUID().toString();
    }
}
