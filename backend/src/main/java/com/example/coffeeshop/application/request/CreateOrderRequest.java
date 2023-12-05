package com.example.coffeeshop.application.request;

import com.example.coffeeshop.domain.models.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderRequest {

    @NotNull
    private List<Product> products;
    private BigDecimal totalPrice;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

//    @JsonCreator
//    public CreateOrderRequest(@JsonProperty("product") @NotNull final List<Product> products) {
//        this.products = products;
//    }

}
