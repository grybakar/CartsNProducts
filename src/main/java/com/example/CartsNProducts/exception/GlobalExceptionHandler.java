package com.example.CartsNProducts.exception;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException notFoundException,
                                                                 WebRequest request) {

        LOGGER.error("ProductNotFoundException: {}", notFoundException.getMessage());
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        final String message = notFoundException.getMessage() == null
                ? notFoundException.getClass().getName() : notFoundException.getMessage();

        final String debugMessage = notFoundException.getCause() == null
                ? notFoundException.toString() : notFoundException.getCause().getMessage();

        ApiErrorMessage apiErrorMessage = ApiErrorMessage.builder()
                .httpStatus(notFound)
//              .message(notFoundException.getLocalizedMessage())
                .message(message)
                .path(request.getDescription(false))
                .debugMessage(debugMessage)
                .build();

        return new ResponseEntity<>(apiErrorMessage, notFound);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<String> errors = fieldErrors.stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        final String debugMessage = exception.getCause() == null
                ? exception.toString() : exception.getCause().getMessage();
        final String message = "One or more field are invalid";

        ApiErrorMessage apiErrorMessage = ApiErrorMessage.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(message)
                .path(request.getDescription(false))
                .debugMessage(debugMessage)
                .subErrors(errors)
                .build();

        return new ResponseEntity<>(apiErrorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * I want to see a detailed error message for all fields that didn't pass validation.
     */
//        ApiFieldErrorMessage apiFieldErrorMessage = ApiFieldErrorMessage.builder()
//                .object(exception.getFieldError().getObjectName())
//                .field(exception.getBindingResult().getFieldError().getField())
//                .rejectedValue((exception.getFieldError().getRejectedValue()))
//                .message(exception.getFieldError().getDefaultMessage())
//                .build();

//        List<ApiFieldErrorMessage> apiFieldErrorMessages = new ArrayList<>();
//        apiFieldErrorMessages.add(apiFieldErrorMessage);

}


