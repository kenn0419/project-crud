package com.kenn.project_crud.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class ErrrorResponse<T> {
    private int statusCode;
    private String path;
    private LocalDateTime timestamp;
    private T errors;
}
