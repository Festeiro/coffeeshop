package com.example.coffeeshop.infrastructure.repository.mongo;

import com.example.coffeeshop.domain.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, Long> {
}
