package com.example.coffeeshop.application.controllers;

import com.example.coffeeshop.application.request.ProductRequest;
import com.example.coffeeshop.application.response.ProductResponse;
import com.example.coffeeshop.domain.services.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServicePort productService;

    @Autowired
    public ProductController(ProductServicePort productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ProductResponse saveProduct(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @GetMapping("/")
    List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
