package com.example.coffeeshop.domain.services;

import com.example.coffeeshop.application.request.ProductRequest;
import com.example.coffeeshop.application.response.ProductResponse;

import java.util.List;

public interface ProductServicePort {

    ProductResponse saveProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(String id);
}
