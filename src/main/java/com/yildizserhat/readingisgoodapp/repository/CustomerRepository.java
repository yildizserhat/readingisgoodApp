package com.yildizserhat.readingisgoodapp.repository;

import com.yildizserhat.readingisgoodapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
