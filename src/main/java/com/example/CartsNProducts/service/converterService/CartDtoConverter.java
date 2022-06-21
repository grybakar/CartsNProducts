package com.example.CartsNProducts.service.converterService;

import com.example.CartsNProducts.dto.CartDto;
import com.example.CartsNProducts.model.Cart;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartDtoConverter {

    private final ModelMapper modelMapper;

    public CartDto convertToDto(Cart cart) {
        return modelMapper.map(cart, CartDto.class);
    }

    public Cart convertFromDto(CartDto cartDto) {
        return modelMapper.map(cartDto, Cart.class);
    }
}
