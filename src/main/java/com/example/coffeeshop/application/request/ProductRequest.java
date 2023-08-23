package com.example.coffeeshop.application.request;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, String category, BigDecimal price) {

}
