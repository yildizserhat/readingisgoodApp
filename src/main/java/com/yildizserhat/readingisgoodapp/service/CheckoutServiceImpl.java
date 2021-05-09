package com.yildizserhat.readingisgoodapp.service;

import com.yildizserhat.readingisgoodapp.dto.PurchaseDTO;
import com.yildizserhat.readingisgoodapp.dto.PurchaseResponseDTO;
import com.yildizserhat.readingisgoodapp.entity.Customer;
import com.yildizserhat.readingisgoodapp.entity.Order;
import com.yildizserhat.readingisgoodapp.entity.OrderItem;
import com.yildizserhat.readingisgoodapp.entity.Product;
import com.yildizserhat.readingisgoodapp.exception.ProductNotFoundException;
import com.yildizserhat.readingisgoodapp.exception.ProductStockException;
import com.yildizserhat.readingisgoodapp.repository.CustomerRepository;
import com.yildizserhat.readingisgoodapp.repository.OrderRepository;
import com.yildizserhat.readingisgoodapp.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchase) {
        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        log.info("Order Tracking Number created: {}", orderTrackingNumber);
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> {
            Long productId = item.getProductId();

            Optional<Product> products = Optional.ofNullable(productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException("Product: " + productId + " id not found")));
            products.stream().forEach(product -> {

                int quantity = product.getUnitsInStock() - item.getQuantity();
                if (quantity < 0) {
                    log.info("Product stock is over for product id: {}", product.getId());
                    throw new ProductStockException("Product cannot be purchased. Stocks should be renewed.");
                }
                product.setUnitsInStock(quantity);
                productRepository.save(product);
                log.debug("Product is purchased and stock amount: {}, stock updated for product id: {}", quantity, productId);
                order.add(item);
            });
        });

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();

        Customer customerFromDb = customerRepository.findByEmail(purchase.getCustomer().getEmail());
        log.debug("Customer: {}", customerFromDb);

        statusToCompleted();

        if (Objects.nonNull(customerFromDb)) {
            customer = customerFromDb;
            log.debug("Customer created the order and not registered before. Customer Email: {}", customer.getEmail());
        }
        customer.add(order);

        customerRepository.save(customer);
        log.info("Customer Created with the email {}:", customer.getEmail());

        return PurchaseResponseDTO
                .builder()
                .orderTrackingNumber(orderTrackingNumber)
                .build();
    }

    private void statusToCompleted() {
        //assume that previous order completed before new one received.
        List<Order> orders = orderRepository.findByStatus(OrderStatus.IN_PROGRESS);
        orders.stream().forEach(order -> {
            order.setStatus(OrderStatus.COMPLETED);
            orderRepository.save(order);
            log.debug("Order is completed, order id:{}", order.getId());
        });
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
