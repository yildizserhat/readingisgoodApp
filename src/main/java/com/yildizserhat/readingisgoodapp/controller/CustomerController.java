package com.yildizserhat.readingisgoodapp.controller;

import com.yildizserhat.readingisgoodapp.dto.CustomerRequestDTO;
import com.yildizserhat.readingisgoodapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody CustomerRequestDTO requestDTO) {
        customerService.registerCustomer(requestDTO);
        return ResponseEntity.ok().build();
    }
}
