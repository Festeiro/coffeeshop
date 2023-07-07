package com.example.coffeeshop.domain.services;

import com.example.coffeeshop.infrastructure.dtos.ProductRecordDto;
import com.example.coffeeshop.domain.models.Product;
import com.example.coffeeshop.infrastructure.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(ProductRecordDto productRecordDto) {
        var product = new Product();
        BeanUtils.copyProperties(productRecordDto, product);
        productRepository.save(product);
        return product;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> delete(Long id) {
        Optional<Product> productO = productRepository.findById(id);
        productRepository.delete(productO.get());
        return productO;
    }
}
