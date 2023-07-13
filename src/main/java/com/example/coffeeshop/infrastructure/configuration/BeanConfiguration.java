package com.example.coffeeshop.infrastructure.configuration;

import com.example.coffeeshop.domain.repository.OrderRepository;
import com.example.coffeeshop.domain.services.OrderServicePort;
import com.example.coffeeshop.domain.services.OrderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackageClasses = SpringBootApplication.class)
public class BeanConfiguration {

    @Bean
    OrderServicePort orderService(final OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }
}
