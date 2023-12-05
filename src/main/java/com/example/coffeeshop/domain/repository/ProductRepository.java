package com.example.coffeeshop.domain.repository;

import com.example.coffeeshop.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(String id);
}
