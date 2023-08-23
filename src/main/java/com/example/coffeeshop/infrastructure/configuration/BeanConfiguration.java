package com.example.coffeeshop.infrastructure.configuration;

import com.example.coffeeshop.domain.repository.OrderRepository;
import com.example.coffeeshop.domain.repository.ProductRepository;
import com.example.coffeeshop.domain.services.OrderServicePort;
import com.example.coffeeshop.domain.services.OrderService;
import com.example.coffeeshop.domain.services.ProductService;
import com.example.coffeeshop.domain.services.ProductServicePort;
import com.example.coffeeshop.domain.utils.mapper.ProductMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderServicePort orderService(final OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    ProductServicePort productService(final ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
