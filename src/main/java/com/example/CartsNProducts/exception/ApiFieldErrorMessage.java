package com.example.CartsNProducts.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.FieldError;

@Data
@AllArgsConstructor
@Builder
public class ApiFieldErrorMessage {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiFieldErrorMessage(String object, String message, FieldError fieldError) {
        this.object = fieldError.getObjectName();
        this.message = message;
    }
}
