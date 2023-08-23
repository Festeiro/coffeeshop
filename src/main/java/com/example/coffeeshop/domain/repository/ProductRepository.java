package com.example.coffeeshop.domain.repository;

import com.example.coffeeshop.domain.models.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    List<Product> getAllProducts();
}
