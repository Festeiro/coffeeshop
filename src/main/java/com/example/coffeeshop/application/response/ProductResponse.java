package com.example.coffeeshop.application.response;

import java.math.BigDecimal;

public record ProductResponse(String name, String description, String category, BigDecimal price) {
}
