package com.example.CartsNProducts.controller;

import com.example.CartsNProducts.model.Cart;
import com.example.CartsNProducts.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        return cartService.findAll();
    }

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteCart(@RequestBody Cart cart) {
        return cartService.delete(cart);
    }


}
