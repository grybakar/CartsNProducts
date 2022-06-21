package com.example.CartsNProducts.validation;

import com.example.CartsNProducts.exception.FieldInputException;
import com.example.CartsNProducts.model.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class ProductValidation {


    /**
     * name, price, quantity
     */

    public void validateProductName(Product product) {

        if (StringUtils.isEmpty(product.getName())) {
            throw new FieldInputException("FIELD CAN'T BE NULL OR EMPTY");
        }
    }

//    public void validateProductPrice(Product product) {
//
//        Double price = product.getPrice();
//        if (price != null && price <= 0) {
//            throw new PriceInputException("PRICE CAN'T BE NULL OR BELOW 0");
//        }

//        public void validateProductQuantity(Product product){
//
//            if (product.getQuantity() < 0 && product.getQuantity() != null  ){
//                throw new QuantityInputException("QUANTITY CAN'T BE NULL OR BELOW 0");
//
//            }
}






