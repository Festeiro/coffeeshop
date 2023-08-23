package com.example.coffeeshop.infrastructure.repository.mongo;

import com.example.coffeeshop.domain.models.Product;
import com.example.coffeeshop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoProductRepository implements ProductRepository {

    private final SpringDataMongoProductRepository springProductRepository;

    @Autowired
    public MongoProductRepository(SpringDataMongoProductRepository springProductRepository) {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public Product save(Product product){
        return springProductRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return springProductRepository.findAll();
    }
}
