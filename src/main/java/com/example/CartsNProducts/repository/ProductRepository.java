package com.example.CartsNProducts.repository;


import com.example.CartsNProducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT WHERE PRICE > 10.0")
    List<Product> findAllByPriceMoreThan();
}
