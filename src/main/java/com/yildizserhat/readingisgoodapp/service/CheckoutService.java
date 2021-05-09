package com.yildizserhat.readingisgoodapp.service;

import com.yildizserhat.readingisgoodapp.dto.PurchaseDTO;
import com.yildizserhat.readingisgoodapp.dto.PurchaseResponseDTO;

public interface CheckoutService {
    PurchaseResponseDTO placeOrder(PurchaseDTO purchase);
}
