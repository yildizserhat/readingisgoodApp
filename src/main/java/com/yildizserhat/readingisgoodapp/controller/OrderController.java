package com.yildizserhat.readingisgoodapp.controller;

import com.yildizserhat.readingisgoodapp.dto.OrderDTO;
import com.yildizserhat.readingisgoodapp.dto.ResponseDTO;
import com.yildizserhat.readingisgoodapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{email}")
    public ResponseEntity<?> showOrder(@PathVariable String email) {
        List<OrderDTO> orderByCustomerEmail = orderService.getOrderByCustomerEmail(email);
        return ResponseEntity.ok(ResponseDTO.builder()
                .object(orderByCustomerEmail)
                .message("Get Order By Customer Email")
                .success(true).build());
    }
}
