package com.example.coffeeshop.domain.services;

import com.example.coffeeshop.domain.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OrderServicePort {

    String createOrder(List<Product> products, BigDecimal price);

    void addProduct(Long id, Product product);

    void completeOrder(Long id);

    void deleteProduct(Long id, Long productId);
}
