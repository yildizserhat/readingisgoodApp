package com.yildizserhat.readingisgoodapp.dto;

import com.yildizserhat.readingisgoodapp.entity.Address;
import com.yildizserhat.readingisgoodapp.entity.Customer;
import com.yildizserhat.readingisgoodapp.entity.Order;
import com.yildizserhat.readingisgoodapp.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
    @NotNull(message = "Please send customer info.")
    private Customer customer;
    @NotNull(message = "Please send shipping address.")
    private Address shippingAddress;
    @NotNull(message = "Please send billing address.")
    private Address billingAddress;
    @NotNull(message = "Order cannot be null.")
    private Order order;
    @NotNull(message = "OrderItems cannot be null")
    private Set<OrderItem> orderItems;
}
