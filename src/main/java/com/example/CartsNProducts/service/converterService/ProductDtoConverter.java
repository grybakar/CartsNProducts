package com.example.CartsNProducts.service.converterService;

import com.example.CartsNProducts.dto.ProductDto;
import com.example.CartsNProducts.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDtoConverter {

    private final ModelMapper modelMapper;

    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public Product convertFromDto(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

}
