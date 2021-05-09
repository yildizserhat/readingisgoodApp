package com.yildizserhat.readingisgoodapp.service;

import com.yildizserhat.readingisgoodapp.dto.OrderDTO;
import com.yildizserhat.readingisgoodapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getOrderByCustomerEmail(String email) {
        return orderRepository.findByCustomerEmail(email);
    }
}
