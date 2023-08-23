package com.example.coffeeshop.domain.services;

import com.example.coffeeshop.application.request.ProductRequest;
import com.example.coffeeshop.application.response.ProductResponse;
import com.example.coffeeshop.domain.models.Product;
import com.example.coffeeshop.domain.repository.ProductRepository;
import com.example.coffeeshop.domain.utils.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements ProductServicePort {

    private final ProductRepository productRepository;

    //@Autowired
    //ProductMapper productMapper;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {

        Product product = productRepository.save(ProductMapper.INSTANCE.toProduct(productRequest));
        return ProductMapper.INSTANCE.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        return productRepository.getAllProducts().stream()
                .map(ProductMapper.INSTANCE::toProductResponse).collect(Collectors.toList());
    }
}
