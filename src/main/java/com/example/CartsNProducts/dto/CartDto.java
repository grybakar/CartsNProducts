package com.example.CartsNProducts.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CartDto {

    private Integer id;
    private Double price;
    private LocalDate orderDate;
    private List<ProductDto> products;
}
