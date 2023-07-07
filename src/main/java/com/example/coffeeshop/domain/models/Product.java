package com.example.coffeeshop.domain.models;

import jakarta.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TB_PRODUCTS")
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;

	private String description;

	private String category;

	private double price;

	private int stock;

}
