package com.example.coffeeshop.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeeshop.domain.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
