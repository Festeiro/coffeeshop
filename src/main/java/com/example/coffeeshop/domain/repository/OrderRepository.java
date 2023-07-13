package com.example.coffeeshop.domain.repository;

import com.example.coffeeshop.domain.models.Order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(Long id);

    void save(Order order);
}
