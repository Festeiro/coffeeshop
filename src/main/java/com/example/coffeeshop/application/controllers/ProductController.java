package com.example.coffeeshop.application.controllers;

import com.example.coffeeshop.infrastructure.dtos.ProductRecordDto;
import com.example.coffeeshop.domain.models.Product;
import com.example.coffeeshop.domain.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productsList = productService.findAll();
//		if(!productsList.isEmpty()) {
//			for(Product product : productsList) {
//				Long id = product.getId();
//				product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
//			}
//		}
		return ResponseEntity.status(HttpStatus.OK).body(productsList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") Long id) {
		Optional<Product> productO = productService.findById(id);
		return productO.<ResponseEntity<Object>>map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found."));
//		productO.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Products List"));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productRecordDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Long id) {
		Optional<Product> productO = productService.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		productService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}

}
