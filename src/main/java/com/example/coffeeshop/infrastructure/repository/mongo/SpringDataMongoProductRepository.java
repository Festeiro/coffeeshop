package com.example.coffeeshop.infrastructure.repository.mongo;

import com.example.coffeeshop.domain.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoProductRepository extends MongoRepository<Product, String> {
}
