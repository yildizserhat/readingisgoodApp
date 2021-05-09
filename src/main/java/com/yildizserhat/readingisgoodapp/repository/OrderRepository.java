package com.yildizserhat.readingisgoodapp.repository;

import com.yildizserhat.readingisgoodapp.dto.OrderDTO;
import com.yildizserhat.readingisgoodapp.entity.Order;
import com.yildizserhat.readingisgoodapp.service.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderTrackingNumber(@RequestParam String trackingNumber);

    List<Order> findByStatus(@RequestParam OrderStatus status);

    @Query("SELECT new com.yildizserhat.readingisgoodapp.dto.OrderDTO(o.orderTrackingNumber,o.status,o.totalPrice)  from Order o where o.customer.email=:email order by o.dateCreated desc")
    List<OrderDTO> findByCustomerEmail(@RequestParam String email);
}
