package com.example.CartsNProducts;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CartsNProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartsNProductsApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


//    @Bean
//    public CommandLineRunner constructCommandLineRunnerBean(final CartRepository cartRepository,
//                                                            final ProductRepository productRepository,
//                                                            final CartDtoConverter cartDtoConverter,
//                                                            final ProductDtoConverter productDtoConverter) {
//        return args -> {
//            CartDto cart = CartDto.builder()
//                    .price(100.99)
//                    .orderDate(LocalDate.of(2022, 6, 12))
//                    .build();
//            cartRepository.save(cartDtoConverter.convertFromDto(cart));
//
//            ProductDto apple = ProductDto.builder()
//                    .name("apple")
//                    .price(1.99)
//                    .quantity(10)
//                    .cartDto(cart)
//                    .build();
//
//            ProductDto lemon = ProductDto.builder()
//                    .name("lemon")
//                    .price(.99)
//                    .quantity(15)
//                    .cartDto(cart)
//                    .build();
//
//            productRepository.save(productDtoConverter.convertFromDto(apple));
//            productRepository.save(productDtoConverter.convertFromDto(lemon));
//        };
//    }

}
