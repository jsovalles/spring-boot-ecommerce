package com.ecommerce.service;

import com.ecommerce.facade.dto.Purchase;
import com.ecommerce.facade.dto.PurchaseResponse;

public interface ICheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
