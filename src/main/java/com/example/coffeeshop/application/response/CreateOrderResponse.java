package com.example.coffeeshop.application.response;

public class CreateOrderResponse {

    private final String id;

    public CreateOrderResponse(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
