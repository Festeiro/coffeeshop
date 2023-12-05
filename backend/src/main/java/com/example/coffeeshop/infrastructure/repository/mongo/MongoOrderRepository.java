package com.example.coffeeshop.infrastructure.repository.mongo;

import com.example.coffeeshop.domain.models.Order;
import com.example.coffeeshop.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MongoOrderRepository implements OrderRepository {

    private final SpringDataMongoOrderRepository orderRepository;

    @Autowired
    public MongoOrderRepository(SpringDataMongoOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(final Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
