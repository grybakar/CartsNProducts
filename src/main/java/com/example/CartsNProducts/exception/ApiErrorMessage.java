package com.example.CartsNProducts.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.cglib.core.MethodWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Builder
public class ApiErrorMessage {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;

    private HttpStatus httpStatus;
    private String message;
    private String debugMessage;
    private String path;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> subErrors;

    public ApiErrorMessage(LocalDateTime timeStamp,
                           HttpStatus httpStatus,
                           String message,
                           String debugMessage,
                           String path,
                           List<String> subErrors) {
        this.timeStamp = LocalDateTime.now();
        this.httpStatus = httpStatus;
        this.message = message;
        this.debugMessage = debugMessage;
        this.path = path;
        this.subErrors = subErrors;
    }

//    public void createValidationError(FieldError fieldError, ApiValidationError apiValidationError) {
//        apiValidationError.setObject(fieldError.getObjectName());
//        apiValidationError.setField(fieldError.getField());
//        apiValidationError.setRejectedValue(fieldError.getRejectedValue());
//        apiValidationError.setMessage(fieldError.getDefaultMessage());
//    }

//    private void addSubError(ApiSubError subError) {
//        if (subErrors == null) {
//            subErrors = new ArrayList<>();
//        }
//        subErrors.add(subError);
//    }

//    private void addValidationError(String object, String field, Object rejectedValue, String message) {
//        addSubError(new ApiValidationError(object, field, rejectedValue, message));
//    }
}
