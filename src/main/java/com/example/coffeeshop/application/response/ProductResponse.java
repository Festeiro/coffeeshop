package com.example.coffeeshop.application.response;

import java.math.BigDecimal;
import java.util.ArrayList;

public record ProductResponse(String id,
                              String name,
                              String description,
                              BigDecimal price,
                              BigDecimal discountPercentage,
                              BigDecimal rating,
                              int stock,
                              String brand,
                              String category,
                              String thumbnail,
                              ArrayList<String> images,
                              int quantity) {
}
