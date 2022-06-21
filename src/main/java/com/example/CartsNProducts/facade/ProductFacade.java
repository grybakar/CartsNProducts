package com.example.CartsNProducts.facade;

import com.example.CartsNProducts.dto.ProductDto;
import com.example.CartsNProducts.model.Product;
import com.example.CartsNProducts.service.converterService.ProductDtoConverter;
import com.example.CartsNProducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Facade layer - to simplify the controller layer.
 * <p>
 * Facade layer will be responsible for the following operation:
 * Data Conversion: Dto/Entity;
 * Fetch required data.
 */

@RequiredArgsConstructor
@Service
public class ProductFacade {

    private final ProductService productService;
    private final ProductDtoConverter productDtoConverter;

    public ProductDto getProductDtoById(Integer productId) {
        return productDtoConverter.convertToDto(productService.findById(productId));
    }

    public List<ProductDto> getAllProductsDto() {
        return productService.findAll()
                .stream()
                .map(productDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductByPriceDto() {
        List<ProductDto> allProductByPriceDto = productService.findAllByPrice()
                .stream()
                .map(productDtoConverter::convertToDto)
                .collect(Collectors.toList());
        return allProductByPriceDto;
    }

    public ProductDto saveProductDto(ProductDto productDto) {
        Product product = productDtoConverter.convertFromDto(productDto);
        return productDtoConverter.convertToDto(productService.save(product));
    }

}
