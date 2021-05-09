package com.yildizserhat.readingisgoodapp.service;

import com.yildizserhat.readingisgoodapp.dto.CustomerRequestDTO;
import com.yildizserhat.readingisgoodapp.entity.Customer;
import com.yildizserhat.readingisgoodapp.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void registerCustomer(CustomerRequestDTO requestDTO) {
        Customer customer = new Customer();
        customer.setEmail(requestDTO.getEmail());
        customer.setFirstName(requestDTO.getFirstName());
        customer.setLastName(requestDTO.getLastName());
        customer.setPhone(requestDTO.getPhone());
        customerRepository.save(customer);
        log.info("Customer is registed with the email: {}", customer.getEmail());
    }
}
