package com.yildizserhat.readingisgoodapp.controller;

import com.yildizserhat.readingisgoodapp.dto.PurchaseDTO;
import com.yildizserhat.readingisgoodapp.dto.PurchaseResponseDTO;
import com.yildizserhat.readingisgoodapp.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/checkout")
@Validated
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/purchase")
    public ResponseEntity<?> placeOrder(@Valid @RequestBody PurchaseDTO purchaseDTO) {
        PurchaseResponseDTO purchaseResponseDTO = checkoutService.placeOrder(purchaseDTO);
        return ResponseEntity.ok(purchaseResponseDTO);
    }
}
