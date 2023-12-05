package com.example.coffeeshop.domain.services;

import com.example.coffeeshop.application.request.ProductRequest;
import com.example.coffeeshop.application.response.ProductResponse;
import com.example.coffeeshop.domain.models.Product;
import com.example.coffeeshop.domain.repository.ProductRepository;
import com.example.coffeeshop.domain.utils.mapper.ProductMapper;
import com.example.coffeeshop.infrastructure.configuration.ImageFilesResources;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService implements ProductServicePort {

    @Autowired
    private ConfigurableApplicationContext context;

    private final ProductRepository productRepository;

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

    @Override
    public ProductResponse getProductById(String id) {
        Optional<Product> product = productRepository.getProductById(id);
        if (product.isPresent()) {
            ImageFilesResources imageFilesResource = context.getBean(ImageFilesResources.class);
            FileSystemResource fileResource = imageFilesResource.findInFileSystem(product.get().getName());

            fileResource.getFilename();
        }
        return product.map(ProductMapper.INSTANCE::toProductResponse).orElseThrow(IllegalArgumentException::new);
    }
}
