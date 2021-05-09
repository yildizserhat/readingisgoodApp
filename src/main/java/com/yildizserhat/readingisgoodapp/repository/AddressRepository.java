package com.yildizserhat.readingisgoodapp.repository;

import com.yildizserhat.readingisgoodapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
