package com.kenn.project_crud.exception;

import com.kenn.project_crud.dto.response.ErrrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrrorResponse<?> handleArgumentException(Exception e, HttpServletRequest request) {
        if (e instanceof MethodArgumentNotValidException ex) {
            List<String> errors = new ArrayList<>();
            BindingResult bindingResult = ex.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(error -> errors.add(error.getDefaultMessage()));

            return ErrrorResponse.<List<String>>builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .path(request.getRequestURI())
                    .timestamp(LocalDateTime.now())
                    .errors(errors)
                    .build();
        }
        return null;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrrorResponse<?> handleBindException(BindException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.add(String.format("'%s' phải là một số nguyên.", fieldError.getField()));
        }

        return ErrrorResponse.<List<String>>builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }
}
