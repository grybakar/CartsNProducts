package com.example.CartsNProducts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "NAME can't be null or < 0")
    private String name;

    @NotNull(message = "PRICE can't null or < 0")
    @Min(value = 0)
    private Double price;

    @NotNull(message = "QUANTITY can't null or < 0")
    @Min(value = 0)
    private Integer quantity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cart_id")
    private Cart cart;


}
