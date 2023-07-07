package com.example.coffeeshop.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(@NotBlank String name,
                               String description,
                               @NotBlank String category,
                               @NotNull double price,
                               @NotNull int stock) {
}
