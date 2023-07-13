package com.example.coffeeshop.domain.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class OrderItems {

    private String productId;
    private BigDecimal price;

//    public OrderItems(final List<Product> products, BigDecimal price) {
//        this.product = product.getId();
//        this.price = price;
//    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private OrderItems() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems orderItem = (OrderItems) o;
        return Objects.equals(productId, orderItem.productId) && Objects.equals(price, orderItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }
}
