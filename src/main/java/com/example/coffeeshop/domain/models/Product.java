package com.example.coffeeshop.domain.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product {

	@Id
	private String id;

	private String name;

	private String description;

	private String category;

	private BigDecimal price;

	private int stock;

	private String imageUrl;

}
