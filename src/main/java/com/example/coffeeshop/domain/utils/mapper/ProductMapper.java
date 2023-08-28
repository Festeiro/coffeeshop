package com.example.coffeeshop.domain.utils.mapper;

import com.example.coffeeshop.application.request.ProductRequest;
import com.example.coffeeshop.application.response.ProductResponse;
import com.example.coffeeshop.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    Product toProduct(ProductRequest productRequest);

    @Mapping(source = "id", target = "id")
    ProductResponse toProductResponse(Product product);
}
