package com.example.CartsNProducts.service;

import com.example.CartsNProducts.model.Cart;
import com.example.CartsNProducts.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    public final Logger LOGGER = LoggerFactory.getLogger(CartService.class);
    private final CartRepository cartRepository;

    public ResponseEntity<List<Cart>> findAll() {
        LOGGER.info("FINDING ALL CARTS");
        List<Cart> allCarts = cartRepository.findAll();
        return new ResponseEntity<>(allCarts, HttpStatus.FOUND);
    }

    public ResponseEntity<Cart> save(Cart cart) {
        LOGGER.warn("CREATING A CART");
        Cart newCart = cartRepository.save(cart);
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> delete(Cart cart) {
        LOGGER.warn("DELETING A CART");
        cartRepository.delete(cart);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
