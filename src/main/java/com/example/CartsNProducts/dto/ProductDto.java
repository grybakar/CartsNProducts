package com.example.CartsNProducts.dto;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto {

    private Integer productId;

    @NotBlank(message = "NAME can't be null or < 0")
    private String name;

    @NotNull(message = "PRICE can't null or < 0")
    @Min(value = 0)
    private Double price;

    @NotNull(message = "QUANTITY can't null or < 0")
    @Min(value = 0)
    private Integer quantity;

    private CartDto cart;
}


