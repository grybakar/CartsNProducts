package com.example.CartsNProducts.service;


import com.example.CartsNProducts.exception.ProductNotFoundException;
import com.example.CartsNProducts.model.Product;
import com.example.CartsNProducts.repository.CartRepository;
import com.example.CartsNProducts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    public final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public List<Product> findAll() {
        LOGGER.info("FINDING ALL PRODUCTS");
        return productRepository.findAll();
    }

    public Product findById(Integer productId) {
        LOGGER.info("FINDING PRODUCT BY ID: {}", productId);
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("NO PRODUCT WITH ID = " + productId));
    }

    /**
     * Using @QUERY annotation example. Finding all products with price higher than 10.
     */

    public List<Product> findAllByPrice() {
        LOGGER.info("FINDING ALL PRODUCT WITH PRICE HIGHER THAN 10.0");
        return productRepository.findAllByPriceMoreThan();
    }


    public Product save(Product product) {
        LOGGER.info("ADDING A NEW PRODUCT: {}", product);
        return productRepository.save(product);
    }

    public List<Product> delete(Product product) {
        LOGGER.warn("DELETING PRODUCT");
        productRepository.delete(product);
        return productRepository.findAll();
    }

    public Product edit(Integer id, Product product) {
        LOGGER.warn("EDITING A PRODUCT");
        Product productToEdit = findById(id);
        productToEdit.setName(product.getName());
        productToEdit.setPrice(product.getPrice());
        productToEdit.setQuantity(product.getQuantity());
        return productToEdit;
    }
}


//    public ResponseEntity<ProductDto> addProductToCart(ProductDto product, Cart cart) {
//        LOGGER.warn("Adding product to Cart");
//        ProductDto productToAssign = productRepository.findById(product.getId()).get();
//        Cart cartToAssign = cartRepository.findById(cart.getId()).get();
//        productToAssign.setCart(cartToAssign);
//        ProductDto assignedToProduct = productRepository.save(productToAssign);
//        return new ResponseEntity<>(assignedToProduct, HttpStatus.OK);
//    }



