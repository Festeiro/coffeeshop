package com.example.coffeeshop.domain.services;

import com.example.coffeeshop.domain.models.Order;
import com.example.coffeeshop.domain.models.Product;
import com.example.coffeeshop.domain.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;

public class OrderService implements OrderServicePort {

    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String createOrder(List<Product> products, BigDecimal price) {
        final Order order = new Order(products, price);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void addProduct(final Long id, final Product product) {
        final Order order = getOrder(id);
//        order.addOrder(product);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(final Long id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(final Long id, final Long productId) {
        final Order order = getOrder(id);
//        order.removeOrder(productId);

        orderRepository.save(order);
    }

    private Order getOrder(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }
}
