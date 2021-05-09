package com.yildizserhat.readingisgoodapp.service;

import com.yildizserhat.readingisgoodapp.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrderByCustomerEmail(String email);
}
