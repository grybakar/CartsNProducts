package com.example.CartsNProducts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private LocalDate orderDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Product> products;


}
