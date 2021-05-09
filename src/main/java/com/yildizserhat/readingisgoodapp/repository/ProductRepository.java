package com.yildizserhat.readingisgoodapp.repository;

import com.yildizserhat.readingisgoodapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
