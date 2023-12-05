package com.example.coffeeshop.domain.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product {

	@Id
	private String id;

	private String name;

	private String description;

	private BigDecimal price;

	private BigDecimal discountPercentage;

	private BigDecimal rating;

	private int stock;

	private String brand;

	private String category;

	private String thumbnail;

	private ArrayList<String> images;

	private int quantity;

}
