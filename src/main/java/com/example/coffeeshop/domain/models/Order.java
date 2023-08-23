package com.example.coffeeshop.domain.models;

import com.example.coffeeshop.domain.DomainException;
import com.example.coffeeshop.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collation = "orders")
@NoArgsConstructor
@Data
public class Order {

    @Id
    private String id;

    private OrderStatus status;

    private List<Product> products;

    private BigDecimal totalPrice;

    public Order(final List<Product> products, BigDecimal price) {
        this.products = products;
        this.status = OrderStatus.CREATED;
        this.totalPrice = price;
    }

    public void complete() {
        validateState();
        this.status = OrderStatus.COMPLETED;
    }

//    public void addOrder(final Product product) {
//        validateState();
//        validateProduct(product);
//        orderItems.add(new OrderItems(product));
//        price = price.add(product.getPrice());
//    }

//    public void removeOrder(final Long id) {
//        validateState();
//        final OrderItems orderItem = getOrderItem(id);
//        orderItems.remove(orderItem);
//
//        price = price.subtract(orderItem.getPrice());
//    }

//    private OrderItems getOrderItem(final Long id) {
//        return orderItems.stream()
//                .filter(orderItem -> orderItem.getProductId()
//                        .equals(id))
//                .findFirst()
//                .orElseThrow(() -> new DomainException("Product with " + id + " doesn't exist."));
//    }

    private void validateState() {
        if (OrderStatus.COMPLETED.equals(status)) {
            throw new DomainException("The order is in completed state.");
        }
    }

    private void validateProduct(final Product product) {
        if (product == null) {
            throw new DomainException("The product cannot be null.");
        }
    }

    public String getId() {
        return id;
    }
}
