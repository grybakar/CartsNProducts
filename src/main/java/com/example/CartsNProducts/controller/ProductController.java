package com.example.CartsNProducts.controller;

import com.example.CartsNProducts.dto.ProductDto;
import com.example.CartsNProducts.facade.ProductFacade;
import com.example.CartsNProducts.model.Product;
import com.example.CartsNProducts.service.converterService.ProductDtoConverter;
import com.example.CartsNProducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductFacade productFacade;
    private final ProductDtoConverter productDtoConverter;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> allProductsDto = productFacade.getAllProductsDto();
        return new ResponseEntity<>(allProductsDto, HttpStatus.FOUND);
    }

    @GetMapping("findById/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable final Integer productId) {
        ProductDto productByIdDto = productFacade.getProductDtoById(productId);
        return new ResponseEntity<>(productByIdDto, HttpStatus.FOUND);
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<List<ProductDto>> getProductsByPrice() {
        List<ProductDto> allProductByPriceDto = productFacade.getAllProductByPriceDto();
        return new ResponseEntity<>(allProductByPriceDto, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody final ProductDto productDto) {
        ProductDto newProductDto = productFacade.saveProductDto(productDto);
        return new ResponseEntity<>(newProductDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<List<ProductDto>> deleteProduct(@RequestBody final ProductDto productDto) {
        productService.delete(productDtoConverter.convertFromDto(productDto));
        List<ProductDto> allProductsDto = productFacade.getAllProductsDto();
        return new ResponseEntity<>(allProductsDto, HttpStatus.OK);
    }

    @PutMapping("/edit/{productId}")
    public ResponseEntity<ProductDto> editProduct(@PathVariable final Integer productId,
                                                  @Valid @RequestBody final ProductDto productDto) {
        Product editedProduct = productService.edit(productId, productDtoConverter.convertFromDto(productDto));
        return new ResponseEntity<>(productDtoConverter.convertToDto(editedProduct), HttpStatus.OK);
    }
}
