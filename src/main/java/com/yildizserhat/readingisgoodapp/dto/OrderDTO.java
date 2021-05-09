package com.yildizserhat.readingisgoodapp.dto;

import com.yildizserhat.readingisgoodapp.service.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderTrackingNumber;
    private OrderStatus status;
    private BigDecimal totalPrice;
}
